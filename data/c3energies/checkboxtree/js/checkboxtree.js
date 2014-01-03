//http://jsfiddle.net/7fn2v/

//global var to hold parsed data
var jsonData = [];
var checkboxTree;

//main function to parse the json data
function data(json) {
	json = $.parseJSON(json);
	var keyIndex = 0;
	var keyIndexMap = {};
	
	for (var key in json) {
		  if (json.hasOwnProperty(key)) {
			  var value = json[key];
			  //a parent node
			  if (value.parent==null) {
			    	CheckboxTreeParser.createParent(keyIndex, jsonData, keyIndexMap, key, value);
			    	keyIndex+=1;
			  //a child node
			  } else {
				    //parent node not yet created, create one
			    	if (keyIndexMap[value.parent]!==undefined) {
			    		CheckboxTreeParser.createChild(jsonData, keyIndexMap, key, value);
			    	} else {
			    		CheckboxTreeParser.createParent(keyIndex, jsonData, keyIndexMap, value.parent);	    	
			    		CheckboxTreeParser.createChild(jsonData, keyIndexMap, key, value);
			    		keyIndex += 1; 
			    	}
		 	   }
		  }
	}
	checkboxTree = new CheckboxTree({el:'.container',data:jsonData});
	checkboxTree.render();
}

//create a parser namespace
CheckboxTreeParser = {};

//parsing function to create a parent node
CheckboxTreeParser.createParent = function(keyIndex, jsonData, keyIndexMap,key, value) {
	jsonData[keyIndex] = {};
	jsonData[keyIndex].name = key;
	if (value && value.selected) {
		jsonData[keyIndex].selected = value.selected;		
	}  	
	keyIndexMap[key] = keyIndex;	
}

//parsing function to create a child node
CheckboxTreeParser.createChild = function(jsonData, keyIndexMap, key, value) {
	var parentIndex = keyIndexMap[value.parent];
	if (!jsonData[parentIndex].children) {
		jsonData[parentIndex].children = [];
	}
	var child = {};
	child.name = key;
	if (value.selected) {
		child.selected = value.selected;
	}
	jsonData[parentIndex].children.push(child);
}

//checkboxTree component
var CheckboxTree = (function(){
	//private component vars
	var el = '';
	var data = [];
	var allChecked = true;
	var allUnchecked = true;
	
	var init = function(attributes) {
		el = attributes.el;
		data = attributes.data;
	};
	//return a backbone view object so we can make the data private
	return Backbone.View.extend({
		events: {
			"click div.tree-toggler": 'toggleTree',
			"click .checkbox" : 'toggleSelection'
		},
		initialize: function(attributes) {
	    	init(attributes);
	    },
	    //PUBLIC API - return a view of the current selection state
	    getData : function() {
	    	var dataView = [];
	        jQuery.each(data, function(index, item) {
	            var newObject = $.extend(true, {}, item);
	            dataView[index] = newObject;
	        });
	    	return dataView;
	    },
	    render: function() {
	    	var parentOpenMap = {};
	    	var indeterminateParentIndexes = [];
	    	//find out the default collaspe and expand state for parent nodes
	    	for (var i=0; i<data.length; i++) {
				//check parent node selection
	    		if (data[i].selected!==undefined && data[i].selected) {
	    			parentOpenMap[data[i].name] = true;
	    		} else {
					//check child node selection
	    			if (data[i].children!==undefined) {
	    				for (var j=0; j<data[i].children.length; j++) {
	    					if (data[i].children[j].selected!==undefined && data[i].children[j].selected) {
	    						parentOpenMap[data[i].name] = true;
	    						//if any child is selected, push the parentIndex to indeterminateParentIndexes
	    						indeterminateParentIndexes.push(i);
	    						break;
	    					}
	    				}
	    					
	    			}
	    		}   		
	    	}
	    	var template = _.template($('#checkboxtree-template').html(), 
	    			{data:data, parentOpenMap: parentOpenMap}
	    	);
	    	$(el).html(template);
	    	
	    	//show semi-checked state for parent node
	    	for (var i=0; i<indeterminateParentIndexes.length; i++) {
	    		$(".parent"+indeterminateParentIndexes[i]).prop({checked:false, indeterminate:true});
	    	}	    		    	
	    },
	    //expand and collapse parent tree node
	    toggleTree: function(ev) {
	    	$(ev.currentTarget).parent().children('ul.tree').toggle(300);
	    	var isTreeOpen = $(ev.currentTarget).hasClass('arrow-down');
	    	if (isTreeOpen) {
	    		$(ev.currentTarget).removeClass('arrow-down');
	    		$(ev.currentTarget).addClass('arrow-right');
	    	} else {
	    		$(ev.currentTarget).removeClass('arrow-right');
	    		$(ev.currentTarget).addClass('arrow-down');
	    	}
	    },
	    toggleSelection: function(ev) {
	    	var parentIndex = $(ev.currentTarget).data('parentindex');
	    	var childIndex = $(ev.currentTarget).data('childindex');
	    	//child node selection changed
	    	if (parentIndex!==undefined && childIndex!==undefined) {
	    		var parent =$(ev.currentTarget).parent().parent().parent();
	    		if ($(ev.currentTarget).attr("checked")) {
	        		allChecked = true;
	        		//update child node selection
	    			data[parentIndex].children[childIndex].selected = true;
	    			//loop through all siblings to see if they are all unchecked
	    			parent.siblings().each(function(index,item){
	    				allChecked = allChecked && $(item).find('input[type="checkbox"]').prop('checked')});
	    			//if all checked, check the parent node
	    			if (allChecked) {
	    				$('.parent'+parentIndex).prop({checked:true, indeterminate:false});
	    				//update parent node selection
	    				data[parentIndex].selected = true;
	    			//if not all checked, semi-check the parent node
	    			} else {
	    				$('.parent'+parentIndex).prop({checked:false, indeterminate:true});
	    				//update parent node selection
	    				delete data[parentIndex].selected;
	    			}    			
	    		} else {
	        		allUnchecked = true;
	        		//update child node selection
	    			delete data[parentIndex].children[childIndex].selected;
	    			//loop through all siblings to see if they are all unchecked
	    			parent.siblings().each(function(index,item){
	    				allUnchecked = allUnchecked && !$(item).find('input[type="checkbox"]').prop('checked')});
	    			//if all unchecked, uncheck the parent node
	    			if (allUnchecked) {
	    				$('.parent'+parentIndex).prop({checked:false, indeterminate:false});
	    				//update parent node selection
	    				delete data[parentIndex].selected;
	    			//if not all unchecked, semi-check the parent node
	    			} else {
	    				$('.parent'+parentIndex).prop({checked:false, indeterminate:true});
	    				//update parent node selection
	    				delete data[parentIndex].selected;
	    			}  
	    		}
	        //parent node selection changed	
	    	} else if (parentIndex!==undefined){
				var parent = $(ev.currentTarget).parent().parent();
	    		if ($(ev.currentTarget).attr("checked")) {
	    			//update parent node selection
	    			data[parentIndex].selected = true;
	    			////find all child input checkbox and check all
	    			parent.siblings('ul').find('li input[type="checkbox"]').each(function(index, item){
	    				$(item).prop({checked:true});
	    				data[parentIndex].children[index].selected = true;	    				
	    			});    			
	    		} else {
	    			//update parent node selection
	    			delete data[parentIndex].selected;
	    			//find all child input checkbox and uncheck all
	    			parent.siblings('ul').find('li input[type="checkbox"]').each(function(index, item){
	    				$(item).prop({checked:false});
	    				delete data[parentIndex].children[index].selected;
	    			});
	    		}	
	    	}  	
	    }
	});
})();

//make jsonp request to get the data - fire jsonp request so I do not need a server to host the data (ajax same orgin policy)
$.ajax({
    url: "https://raw.github.com/cskevint/interview/master/checkbox_tree.json",
    dataType: "jsonp"   
});

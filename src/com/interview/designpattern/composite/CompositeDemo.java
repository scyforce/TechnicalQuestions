package com.interview.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/*
 * Composite pattern is relatively simple, but it has been used in many designs, such as SWT, eclipse workspace, etc.
 * 
 * It basically produce a hierarchical tree which can be accessed by using a uniform method.
 *
 * Composite pattern is like combination.
 * 
 */
class CompositeDemo implements Component {

	private List<Component> childComponents = new ArrayList<Component>();

	public void add(Component component) {
		childComponents.add(component);
	}

	public void remove(Component component) {
		childComponents.remove(component);
	}

	@Override
	public void show() {
		for (Component component : childComponents) {
			component.show();
		}
	}
}

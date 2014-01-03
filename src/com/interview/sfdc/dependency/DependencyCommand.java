package com.interview.sfdc.dependency;

import java.util.Set;

public interface DependencyCommand {
    void depend(ProgramDependency programDependency, String program, Set<String> dependencies);
    String install(ProgramDependency programDependency, String program);
    String remove(ProgramDependency programDependency, String program);
    String list(ProgramDependency programDependency);
}

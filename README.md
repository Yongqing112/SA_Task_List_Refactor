# Task List &nbsp; [![Build Status](https://travis-ci.org/codurance/task-list.png)](https://travis-ci.org/codurance/task-list)

2024/03/17
1.  move UseCaseInteractor to CommandController and Extract classes of Tasks, Project, and ProjectName.
    -  **entity**
        -    Project
        -    ProjectName
        -    Task
        -    Tasks
        -    TaskList
    -  **usecase**
        -    **command**
             -    Command(Interface)
        -    **inputPort**
             -    InputBoundary(interface)
             -    inputData
        -    **outputPort**
             -    OutputBoundary(interface)
             -    OutputData
    -  **interfaceAdapter**
        -    **controller**
             -    CommandController
        -    **presenter**
             -    CommandPresenter
    -  **Persistence(Framework & Driver)**
        -    **io**
             -    Input
             -    Output
        -    TaskListRunner

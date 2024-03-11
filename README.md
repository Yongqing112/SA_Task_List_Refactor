# Task List &nbsp; [![Build Status](https://travis-ci.org/codurance/task-list.png)](https://travis-ci.org/codurance/task-list)

2024/03/11
1.  Rearrange classes to conform to Clean Architecture
    -  **entity**
        -    Task
        -    TaskList
    -  **usecase**
        -    UseCaseInteractor
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
    -  **io(Framework & Driver)**
        -    Input
        -    Output
        -    TaskListRun

# Task List &nbsp; [![Build Status](https://travis-ci.org/codurance/task-list.png)](https://travis-ci.org/codurance/task-list)

2024/03/22
1.  rename Tasks to ProjectList and use Aggregate(TaskList -> ProjectList -> Project -> Task).
    -  **entity**
        -    ProjectName
        -    ProjectList
        -    Project
        -    Task
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

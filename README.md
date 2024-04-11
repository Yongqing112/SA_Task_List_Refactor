# Task List &nbsp; [![Build Status](https://travis-ci.org/codurance/task-list.png)](https://travis-ci.org/codurance/task-list)

2024/04/11
1.  (1) Implement Use Case: AddProjectUseCase, AddTaskUseCase, SetDoneUseCase
2.  (2) Implement Use Case Input: AddProjectInput, AddTaskInput, SetDoneInput, ErrorInput
    -  **entity**
        -    `ProjectListId`
        -    ProjectName
        -    `ProjectList`
        -    Project
        -    ReadOnlyProject
        -    ReadOnlyTask
        -    TaskId
        -    Task
    -  **usecase**
        -    **command**
             -    `AddProjectUseCase`
             -    `AddTaskUseCase`
             -    `SetDoneUseCase`
        -    **inputPort**
             -    InputBoundary(interface)
             -    inputData
             -    `AddProjectInput`
             -    `AddTaskInput`
             -    `SetDoneInput`
             -    `ErrorInput`
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

2024/04/06
1.  (1) Apply DDD tactical designs to the entities layer. (2) Enforce aggregate invariants by implementing ReadOnly subtypes for Project and Task.
    -  **entity**
        -    ProjectName
        -    ProjectList
        -    Project
        -    ReadOnlyProject
        -    ReadOnlyTask
        -    TaskId
        -    Task
        -    TaskListId
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

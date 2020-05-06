学习笔记

## 前序知识回顾

* 树的问题一般都是递归解决, 为什么?

1. 树的数据结构本身的定义就是符合递归模型的
2. 树的问题具备重复性

## 递归

1. 递归终结条件
2. 处理当前层逻辑
3. 下探到下一层
4. 清理当前层

> 三个思维要点:

1. 不要人肉进行递归
2. 找最近重复子问题
3. 数学归纳法思维

> 递归代码模板:

```java
public void recur(int level, Object param) {
    // terminator
    if (level > MAX_LEVEL) {
        // process result
        return;
    }
    
    // process current logic
    process(level, param);
    
    // drill down
    recur(level - 1, param);

    // restore current status
}
```
## 分治和回溯

本质上来讲, 分治和回溯是特殊的递归.

> 分治代码模板:

```python
def divide_conquer(problem, param1, param2, ...) 
    # recursion terminator
    if problem is None:
        print_result
        return
    # prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)
    # conquer subproblems
    subresult1 = self.divide_conquer(subproblems[0], p1, ...)
    subresult2 = self.divide_conquer(subproblems[1], p1, ...)
    subresult3 = self.divide_conquer(subproblems[2], p1, ...)
    ...
    # process and generate the final result
    result = process_result(subresult1, subresult2, subresult3, ...)
    # revert the current level states 
```
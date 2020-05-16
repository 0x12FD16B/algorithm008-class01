# Week4 学习笔记

## 深度优先搜索和广度优先搜索

> DFS 代码模板

1. 递归写法

```python
visited = set()

def dfs(node, visited):
    if node in visited: # terminator
        # already visited
        return
    
    visited.add(node)

    # process current node here.
    ...
    for next_node in node.children():
        if next_node not in visited:
            dfs(next_node, visited)

```

2. 非递归写法

```python
def dfs(self, tree):
    if tree.root is None:
        return []

    visited, stack = [], [tree.root]

    while stack:
        node = stack.pop()
        visited.add(node)

        process (node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)

    # other processing work
    ...
```

> BFS 代码模板

```python
    def bfs(graph, start, end):
        visited = set()
        queue = []
        queue.append([start])
        
        while queue:
            node = queue.pop()
            visited.add(node)

            process(node)
            nodes = generate_related_nodes(node)
            queue.push(nodes)
        
        # other processing work
        ...
```

## 贪心算法

贪心算法是一种在每一步选择中都采取在当前状态下最好或者最优(最有利)的选择, 从而希望导致结果是全局最好或者最优的解法。

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

> 适用贪心算法的场景

问题能够分解成子问题来解决, 子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。

## 二分查找

> 二分查找的前提

1. 目标函数单调性 (单调递增、单调递减)
2. 存在上下界 (bounded)
3. 能够通过索引访问 (index accessible)

> 代码模板

```python
left, right = 0, len(array) - 1
while (left <= right)
    mid = (left + right) / 2
    if (array[mid] == target):
        # find the target!!
        break or return result
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
```

## 思考题

> 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

思路: 问题可以转换成寻找旋转数组第一次出现元素比之前元素小的下标。

代码如下:

```java
    public int findRotatedPoint(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        if (nums[hi] > nums[lo]) return -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid + 1]) return mid + 1;
            if (nums[mid - 1] > nums[mid]) return mid;
            if (nums[mid] > nums[0]) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
```

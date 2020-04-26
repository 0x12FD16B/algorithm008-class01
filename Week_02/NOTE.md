# 学习笔记

## 课堂知识点整理

### Hash Table
哈希表 (Hash Table), 也叫散列表, 是根据关键码值 (Key value) 而直接进行访问的数据结构.
它通过把关键码值映射到表中一个位置来访问记录, 以加快查找的速度。

这个映射函数叫做散列函数 (Hash Function), 存放记录的数组叫作哈希表 (或散列表)。

* Hash Collisions (哈希碰撞)
解决 Hash 碰撞的方法:
1. 拉链法
2. 开放寻址法
3. 多重散列法

* 在工程中解使用 Hash 表一般使用开发预演中包装好的类库, 比如 Java 语言中的 Map, Set 的实现

### 树

树是特殊的链表, 一个节点有多个指针指向其他节点。

### 二叉树

二叉树，顾名思义，每个节点最多有两个“叉”，也就是两个子节点，分别是左子节点和右子节点。不过，二叉树并不要求每个节点都有两个子节点，有的节点只有左子节点，有的节点只有右子节点。

### 二叉搜索树 (Binary Search Tree)

二叉搜索树, 也称二叉排序树、有序二叉树、排序二叉树、是指一颗空树或者具有下列性质的二叉树：

1. 左子树上*所有节点*的值均小于它的根节点的值;
2. 右子树上*所有节点*的值均小于它的根节点的值;
3. 以此类推: 左、右子树也分别为二叉查找树。

如果中序遍历一棵二叉搜索树, 得到的是树节点元素的升序排列。

二叉查找树常见操作的时间复杂度如下:

1. 查找: O(logN)
2. 插入: O(logN)
3. 删除: O(logN)

* 二叉树的遍历方式

前序遍历: 根 -> 左 -> 右

中序遍历: 左 -> 根 -> 右

后序遍历: 左 -> 右 -> 根

### 堆 (Heap)

Heap: 可以迅速找到一堆数中的最大或者最小值的数据结构。

将根节点最大的堆叫做大顶堆或大根堆，根节点最小的堆叫做小顶堆或小根堆。常见的堆有二叉堆、斐波那契堆等。

假设是大顶堆，则常见操作：

find-max: O(1)
delete-max: O(logN)
insert(create): O(logN) or O(1)

不同实现的比较: https://en.wikipedia.org/wiki/Heap_(data_structrue)

### 图 (Graph)

## 做题四件套

1. clarification
2. possible solutions --> optimal (time & space)
3. code
4. test cases

## 实战题目

> 哈希表

* https://leetcode-cn.com/problems/valid-anagram
* https://leetcode-cn.com/problems/group-anagrams
* https://leetcode-cn.com/problems/two-sum

> 树

* https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
* https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
* https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
* https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
* https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/

> 堆

## 思考题

树的面试题解法一般都是递归，为什么？

因为树的问题在子树上具有相似性, 整体问题的求解需要局部重复部分的问题 "归集" 得到问题的解, 一般可以使用递归求解。
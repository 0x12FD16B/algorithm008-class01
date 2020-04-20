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

// todo HashMap 总结

## 做题四件套

1. clarification
2. possible solutions --> optimal (time & space)
3. code
4. test cases

## 实战题目
* https://leetcode-cn.com/problems/valid-anagram
* https://leetcode-cn.com/problems/group-anagrams
* https://leetcode-cn.com/problems/two-sum

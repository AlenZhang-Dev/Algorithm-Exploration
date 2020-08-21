# 18. 删除链表的节点

在`O(1)`时间内删除链表节点. 

给定单向链表的头指针和一个节点指针, 定义一个函数在`O(1)`时间内删除该节点. 链表节点与函数的定义如下:

```c++
struct ListNode{
  	int m_nValue;
  	ListNode* m_pNext;
};

void DeleteNode(ListNode **pListHead, ListNode* pToBeDeleted);
```



## 解析

链表删除常规操作需要找到被删除节点的前一个节点.这样就不满足题目的时间要求.

因此我们可以把下一个节点的内容复制到需要删除的节点上覆盖原有内容, 再把下一个节点删除, 即可以相当于删除了链表节点.

需要考虑两种特殊情况:

1. 删除节点在链表的末尾, 也就是没有后置节点, 只能从头开始遍历找到前面节点再进行删除.
2. 如果链表只有一个节点, 将其删除, 同时把链表头节点设置为nullptr.



## 题解

```c++
void DeleteNode(ListNode** pListHead, ListNode* pToBeDeleted){
  	if(pListHead || !pToBeDeleted)
      	return;
  	//删除正常节点
  	if(pToBeDeleted -> m_pNext != nullptr){
      	ListNode* pNext = pToBeDeleted -> pNext;
      	pToBeDeleted -> m_nValue = pNext -> m_nValue;
      	pToBeDeleted -> m_pNext = pNext -> m_pNext;
      
      	delete pNext;
      	pNext = nullptr;
    }
  
 		//链表只有一个节点,删除头节点
  	else if(*pListHead == pToBeDeleted){
      	delete pToBeDeleted;
      	pToBeDeleted = nullptr;
      	*pListHead = nullptr;
    }
  	
  	//链表中有多个节点, 删除尾节点
  	else{
      	ListNode *pNode = *pListHead;
      	while(pNode -> m_pNext != pToBeDeleted){
          	pNode = pNode -> m_pNext;
        }
      	
      	pNode -> m_pNext = nullptr;
      	delete pToBeDelete;
      	pToBeDelete = nullptr;
      
    }
}
```

注: 以上程序对于尾节点来说, 需要`O(n)`时间才能删除, 但总的时间复杂度依旧为`O(1)`, 符合题目要求.

上述题解基于删除的节点的确在链表中这一假设.


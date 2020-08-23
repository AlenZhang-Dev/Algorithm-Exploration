# 23. 链表中环的入口节点

如果一个链表中包含环, 如何找出环的入口节点?



## 解析

使用快慢指针可以判断链表是否包含环.

如何找到环的入口.依旧可以用两个指针来解决. 定义P1和P2两个节点, 如果链表中的环有n个节点, 则指针P1先在链表上移动n步, 然后两个指针同时以相同速度移动. 当第二个指针指向环的入口节点时, 第一个指针已经绕环走了一圈, 也指向入口节点.

```c++
//MeetingNode判断,如果链表存在环, 返回pFast指针,如果不存在环, 返回nullptr
ListNode *MeetingNode(ListNode* pHead){
  	if(pHead == nullptr)
      	return nullptr;
  
  	//set up Slow Pointer
  	ListNode* pSlow = pHead -> m_pNext;
  	if(pSlow == nullptr)
      	return nullptr;
  
  	ListNode* pFast = pSlow -> m_pNext;
  	while(pFast != nullptr && pSlow != nullptr){
      	if(pFast == pSlow)
          	return pFast;
      	
      	pSlow = pSlow -> m_pNext;
      
      	pFast = pFast -> m_pNext;
      	if(pFast != nullptr)
          	pFast = pFast -> m_pNext;
    }
  
  	return nullptr;
}
```

找到环内任意节点后, 能得出环中节点数目, 并找到环的入口节点, 对应代码如下:

```c++
ListNode* EntryNodeOfLoop(ListNode* pHead){
  	ListNode* meetingNode = MeetingNode(pHead);
  	if(meetingNode == nullptr)
      	return nullptr;
  	
  	//得到环中节点的数目
  	int nodesInLoop = 1;
  	ListNode* pNode1 = meetingNode;
  
  	while(pNode1 -> m_pNext != meetingNode){
      	pNode1 = pNode1 -> m_pNext;
      	++nodesInLoop;
    }
  
  	//pNode1移动次数为环的数目
  	pNode1 = pHead;
  	for(int i = 0; i < nodesInLoop; ++i)
      	pNode1 = pNode1 -> m_pNext;
  	
  	//再pNode1和pNode2同时移动,知道相遇.
  	ListNode* pNode2 = pHead;
  	while(pNode1 != pNode2){
      	pNode1 = pNode1 -> m_pNext;
      	pNode2 = pNode2 -> m_pNext;
    }
  
  	return pNode1;
}
```




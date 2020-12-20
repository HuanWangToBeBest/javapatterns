package com.pattern.review;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNodeBinary {

    public static void preTreeNode(TreeNode treeNode){
        // 递归先序遍历
        System.out.println(treeNode.value);// 首节点
        TreeNode leftNode = treeNode.left;
        if (leftNode != null){
            preTreeNode(leftNode);
        }
        TreeNode rightNode = treeNode.right;
        if (rightNode != null){
            preTreeNode(rightNode);
        }
    }

    public static void preOrder(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()){
            while (treeNode != null){
                System.out.println(treeNode.value);// 首节点
                stack.push(treeNode);//左分支
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    public static void midOrder01(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        midOrder01(treeNode.left);
        System.out.println(treeNode.value);
        midOrder01(treeNode.right);
    }

    public static void midOrder02(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        if (treeNode == null){
            return;
        }
        while (treeNode != null){
            while (treeNode != null){
                stack.push(treeNode.left);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()){
                stack.pop();
                assert false;
                System.out.println(treeNode.value);
                treeNode = treeNode.right;
            }
        }
    }

    public static void postOrder02(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        postOrder02(treeNode.right);
        postOrder02(treeNode.left);
        System.out.println(treeNode.value);
    }

//    public static void postOrder01(TreeNode treeNode){
//        Stack<TreeNode> stack = new Stack<>();
//        if (treeNode == null){
//            return;
//        }
//        while(treeNode != null || !stack.isEmpty()){
//            while (treeNode != null){
//                stack.push(treeNode.right);
//                treeNode = treeNode.right;
//            }
//            if (!stack.isEmpty()){
//                stack.pop();
//                treeNode = treeNode.left;
//                System.out.println(treeNode.value);
//            }
//        }
//    }

    public static void levelOrder(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(treeNode);
        TreeNode currentNode;
        while(!linkedList.isEmpty()){
            currentNode = linkedList.poll();
            System.out.println(currentNode.value);
            if (currentNode.left != null){
                linkedList.add(currentNode.left);
            }
            if (currentNode.right != null){
                linkedList.add(currentNode.right);
            }
        }
    }

    // 递归
    public static LinkedNode reserveNode(LinkedNode head){
        if (head == null || head.next == null){
            return head;
        }
        LinkedNode temp = head.next;
        LinkedNode newHead = reserveNode(head.next);
        temp.next = head;
        newHead.next = null;
        return newHead;
    }

    public static LinkedNode reserveNode01(LinkedNode head){
        if (head == null || head.next == null){
            return head;
        }
        LinkedNode preNode = null;
        LinkedNode postNode;
        while (head != null){
            postNode = head.next;
            head.next = preNode;
            preNode = head;
            head = postNode;

        }
        return preNode;
    }

    public static LinkedNode reserveNode02(LinkedNode head){
        LinkedNode pre = null;//pre指向null
        LinkedNode curr = head;// 当前节点指向头结点
        while (curr != null){
            LinkedNode next = curr.next;// 临时节点指向头结点的下一个节点
            curr.next = pre;// 头结点指向下一个节点的，改为指向pre节点，即指向null  [1]->[2]  中间-> 断开，指向null
            pre = head;// pre节点指向头结点
            curr = next;// 当前节点移到下一个节点，后面继续上述步骤
        }
        return pre;// 这个是链表反转后的头结点
    }

}

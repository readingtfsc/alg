package com.moogflow.alg.arrayqueue;




/**
 * 
 *	һ���Բ��ɸ��õĶ���
 */
public class ArrayQueueDemo {
	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(8);
		arrayQueue.addQueue(1);
		arrayQueue.addQueue(2);
		arrayQueue.addQueue(3);
		arrayQueue.addQueue(7);
		arrayQueue.addQueue(8);
		arrayQueue.addQueue(9);
		arrayQueue.list();
		
		int queue;
		try {
			queue = arrayQueue.getQueue();
			System.out.println("ȡ�����ݣ�"+queue);
			
			queue = arrayQueue.getQueue();
			System.out.println("ȡ�����ݣ�"+queue);
			
			int peekQueue = arrayQueue.peekQueue();
			System.out.println("͵�����ݣ�"+peekQueue);
			
			queue = arrayQueue.getQueue();
			System.out.println("ȡ�����ݣ�"+queue);
			
			peekQueue = arrayQueue.peekQueue();
			System.out.println("͵�����ݣ�"+peekQueue);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
			
	}
}

// ��������ʵ�ֵĶ���
class ArrayQueue {
	private int size;	//����Ԫ�ص�������
	//ͷβ�ڱ�
	private int front; // ����ͷָ�� ָ�����ͷ������һ��Ԫ�أ���ǰһ��λ��
	private int rear ; // ����βָ�� ָ����е�β��λ��  ���������һ�����ݣ�
	private int[] array; //���д�����ݵ�����
	

	public ArrayQueue(int maxSize) {
		// TODO Auto-generated constructor stub
		this.size = maxSize;
		this.array = new int[maxSize];
		this.front = -1; //ָ�����ͷ����ǰһ��λ��
		this.rear = -1;  //ָ����е�β��λ��  ���������һ�����ݣ�
	}
	
	public boolean isFull() {
		//���β��ָ��ָ���������е����һ��λ�ã��������
		return front == size;
	}
	public boolean isEmpty() {
		//�����λָ��ָ��ͬһ��λ�ã������Ϊ��
		return front == rear;
	}
	public void addQueue(int num) {
		
		//1. �ж�������?
		if (isFull()) {
			System.out.println("������,���ܼ�������..");
			return;
		}
		
		//2. βָ�����һλ������������ݵ�������
		rear++;
		array[rear] = num;

	}
	
	// ���ݳ�����
	public int getQueue() {
		// 1. �ж϶����Ƿ�Ϊ��
		if (isEmpty()) {
			// �׳��쳣����
			throw new RuntimeException("queue is empty..");
		}
		
		// 2. ��Ϊ ͷ��ָ��ָ���ײ���ǰһλ,����ͷ��ָ������ƶ�һλ,����ȡ������
		front ++;
		return array[front];
	}
	
	//��ʾ���е��������ݣ�ע�ⲻ��ȡ��
	public void list() {
		// 1. �ж϶����Ƿ�Ϊ��
		if (isEmpty()) {
			// �׳��쳣����
			System.out.println("queue is empty..");
			return;
		}
		
		int len = rear+1;
		for (int i = 0; i < len ; i++) {
			System.out.printf("array[%d] = %d\n", i,array[i]);
		}
	}
	
	//͵��
	public int peekQueue() {
		if (isEmpty()) {
			throw new RuntimeException("queue is empty..");
		}
		return array[front+1];
	}
	
	
}

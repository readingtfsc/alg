package com.moogflow.alg.arrayqueue;



/*
 * ���οɸ��õĶ��� 
 * ʵ�ַ�����ȡģ %
 * 
 */
/**
 * 
 * ΪʲôҪԤ����һ���ռ�?
 * ѭ�������У��������ʱβָ����ǰ׷��ͷָ�룻����ʱͷָ����ǰ׷��βָ�룬��ɶӿպͶ���ʱͷβָ�����ȡ�
 * ��ˣ��޷�ͨ������front==rear���б������"��"����"��"�������˷ѵ�һ���ռ�ȥ�ж϶����Ƿ�ջ�������
 * 
 * so,Ԥ����һ���ռ���ΪԼ���������ǰ�� ��� βָ����ѭ�������µ�+1����� ���� ͷָ�루׷����ͷָ�룩���������ˡ�
 * 
 * so����βָ�� �� ͷָ����ȵ�ʱ��ͷָ��׷����βָ�� ���ԣ�Ϊ�ա�
 * 
 */

/**
 * 
 * ˼·������
 * ͷָ��ָ�� ���еĵ�һ��Ԫ�ص�λ��
 * βָ��ָ����е����һ��Ԫ�صĺ�һ��λ��  Ԥ������һ��λ����ΪԼ��
 *
 *	1. ������������  ͷָ�� == (βָ�� + 1) % size;
 *	��⣺
 *	2. ����Ϊ�յ����� ͷָ���βָ�� ָ��ͬһ��λ�õ�ʱ�򣬶���Ϊ�� ; ͷָ�� == βָ�� 
 *
 *	3.���е���Ч���� (βָ�� + size - ͷָ��) % size�� 
 *	��⣺������� ��λָ���໥׷�ϵ����⡣�����������λָ���໥׷�ϣ���rear - front ��Ϊ��ЧԪ�صĸ���
 *		    �����ǻ��Σ���λָ���໥׷�ϣ����Դ��� rear < front ��������ڡ���rear �ڻ����Ͽ�ʼ�ߵڶ�Ȧ��
 *		
 */
public class ArrayCircleQueueDemo {
	public static void main(String[] args) {
		ArrayCircleQueue queue = new ArrayCircleQueue(4);
		queue.addQueue(1);
		queue.addQueue(2);
		queue.addQueue(3);
		queue.addQueue(4);
		queue.list();
		
	int i = queue.getQueue();
	
	System.out.println("get queue is "+i);
	queue.addQueue(5);
	queue.list();
	}
}

class ArrayCircleQueue{
	private int size;	//����Ԫ�ص�������
	//ͷβ�ڱ�
	private int front; // ����ͷָ��   ָ����е�һ��Ԫ�ص�λ��
	private int rear ; // ����βָ��	 ָ��������һ��Ԫ�صĺ�һ��λ�� Ϊ����Ԥ����һ��λ�á� -->Ԥ���������λ�� ʹ�� ����ռ�ȶ��пռ��һ��λ��
	
	private int[] array; //���д�����ݵ�����
	
	
	public ArrayCircleQueue(int maxSize) {
		// TODO Auto-generated constructor stub
		this.size = maxSize+1;
		this.array = new int[maxSize+1];
		this.rear = 0;
		this.front = 0;
	}
	
	// ��Ӷ���
	public void addQueue(int num) {
		if (isFull()) {
			System.out.println("queue is full.....");
			return; 
		}
		
		// �ж� rear �Ƿ���� size 
		if (rear>=size) {
			array[rear] = num;
			rear =0;
			return;
		}
		
		// ��������ӵ�
		array[rear] = num;
		rear++;
	}
	
	
	
	// �����Ƿ��
	public boolean isEmpty(){
		return  rear == front;
	}
	// �����Ƿ���
		public boolean isFull(){
			return front == (rear + 1) % size;
		}
	//��������Ч���ݵĸ���
	public int getNum(){
		if (isEmpty()) {
			return -1;
		}
		return (rear+size-front)%size;
	}
	
	public int getQueue() {
		
		if (isEmpty()) {
			System.out.println("queue is empty..");
			throw new RuntimeException("queue is empry..");
		}
		
		if (front >=size) {
			front=0;
		}
		
		int num = array[front];
		front++;
		return num;
		
	}
	
	public void list() {
		if (isEmpty()) {
			System.out.println("queue is empty..");
			throw new RuntimeException("queue is empry..");
		}
		
		int len = (rear+size-front)%size;
		System.out.println("len = "+len);
		
		for (int i = front; i <len+front  ; i++) {
			if (i >=size) {
				i=0;
			}
			System.out.println(array[i]);
			
		}
	}
}

package com.moogflow.alg.linkedlist;



public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLinkedList list = new SingleLinkedList();
//		list.addNode(new Node(1, "�ν�", "��ʱ��"));
//		
//		list.addNode(new Node(2, "¬����", "������"));
//		list.addNode(new Node(3, "����", "�Ƕ���"));
		
		list.addNodeByOrder(new Node(2, "�ֳ�", "����ͷ"));
		list.addNodeByOrder(new Node(1, "�ν�", "��ʱ��"));
		list.addNodeByOrder(new Node(4, "����", "�Ƕ���"));
		list.addNodeByOrder(new Node(2, "¬����", "������"));
		
		
		list.list();
		list.update(new Node(2, "����", "����"));
		list.list();
		
		list.del(1);
		list.list();
	}

}

class SingleLinkedList{
 
	//��ʼ��ͷ���--�����κ����� ����ָ���һ���ڵ�
	private Node head  = new Node(0, "", "");
	
	//�յĹ�����
	public SingleLinkedList() {}
	
	public void del(int no){
		//�ж������Ƿ�Ϊ��
		if (head.next ==null) {
			System.out.println("����Ϊ��..����ɾ��...");
			return;
		}
		Node temp = head;
		boolean flag =false;
		while (true) {
			if (temp.next ==null) {
				break;
			}
			if (temp.next.no == no) {
				flag = true;
				temp.next = temp.next.next;
				System.out.println("ɾ���ɹ�..");
			}
			temp = temp.next;
			
		}
		if (!flag) {
			System.out.printf("�����ڡ�%d��\n",no);
		}
	}
	
public void update(Node node){
	//�ж������Ƿ�Ϊ��
	if (head.next ==null) {
		System.out.println("����Ϊ��..�޸�ʧ��...");
		return;
	}
	Node temp= head;
	boolean flag = false;
	while (true) {
		if (temp.next ==null) {
			break;
		}
		if (temp.no == node.no) {
			flag = true;
			String oldName =temp.name;
			temp.name =  node.name;
			temp.nikeName = node.nikeName;
			System.out.printf("�޸ĳɹ�.. %s to %s\n",oldName,node.name);
		}
		temp = temp.next;
		
	}
	if (!flag) {
		System.out.printf("�����ڡ�%d��\n",node.no);
	}
	}
	
	
	public void addNodeByOrder(Node node) {
		
	
		
		//���ǵ���Ҫ����ָ��
		Node temp = head;
		
		while(true){
			//�ж��Ƿ�Ϊ������
			if (temp.next ==null) {
				temp.next = node;
				return;
			}
			
			//�ҵ���Ҫ�����λ��   
			//��Ϊ�Ѿ��жϹ������Ƿ�Ϊ�գ����Դ˿�������������һ���ڵ�
			if (temp.next.no>= node.no) {
				//  ��Ҫ��ӵ�λ�õĺ�һ��λ��  ָ�� ��λ�õ�next
				node.next = temp.next;
				//  ��Ҫ��ӵ�λ�õ�ǰһ��λ�� ָ����λ��
				temp.next = node;
				break;
			}
			
			
			
			//�ƶ�ָ��
			temp = temp.next;
		}
	}
	
	
	public void addNode(Node node) {
		
		//���� ���� �ҵ����һ���ڵ� 
		
		// Ϊʲô��Ҫһ������ָ�� ��Ϊͷָ�벻�ܶ������������ͱ��ƻ���
		Node temp = head;
		while(true){
			// �ж���һ���ڵ��Ƿ�Ϊ��
			if (temp.next == null) {
				temp.next = node;
				break;
			}
			//�ƶ�ָ��
			temp = temp.next;
		}
		
		
		
		
	}
	public void list() {
		//�ж������Ƿ�Ϊ��
		if (head.next ==null) {
			System.out.println("����Ϊ��...");
			return;
		}
		
		Node temp = head.next;
		while (true) {
			//�жϽڵ��Ƿ�Ϊ���һ���ڵ�ĺ�һ���ڵ� 
			//�����ֱ���˳�ѭ��
			//Ϊʲô�����һ���ڵ�ĺ�һ���ڵ���?
			//��ΪҪ��ӡ������һ���ڵ�,���Ա��������һ���ڵ�ĺ�һ���ڵ�  �� null ���бȽϣ�
			//�����Ǻ� ���һ���ڵ��ָ���� ���бȽϣ������޷���ӡ���һ���ڵ�
			if (temp == null) {
				break;
			}
			
			//��ӡ�ڵ�
			System.out.println(temp);
			
			//�ƶ�ָ��
			temp = temp.next;
			
		}
		
	}
 
 
}

class Node {
	int no;
	String name;
	String nikeName;
	Node next;
	
	//���캯��
	public Node(int  no,String name ,String nikeName) {
		// TODO Auto-generated constructor stub
		this.no = no;
		this.name = name;
		this.nikeName = nikeName;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + ", nikeName=" + nikeName + "]";
	}
	
	
}
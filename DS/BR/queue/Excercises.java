package queue;

import java.util.Stack;

public class Excercises {
	
	/*
	 *  #1. ť�� Q�� �׸���� ������ ������ �˰����� �����϶�. ť�� �׼����� �� ť ADT�� �Լ��鸸 �̿��ؾ� �Ѵ�.
	 */
	public static Queue reverseQueue(Queue queue) {
		Stack stack = new LLStack();
		while(!queue.isEmpty()) {
			stack.push(queue.dequeue());
		}
		while(!queue.isEmpty()) {
			stack.enqueue(stack.pop());
		}
		return queue;
	}
	
	/*
	 * #2. �� ���� �������� ť�� �����Ϸ��� ��� �ϴ°�?
	 * 
	 * enqueue: ���� S1�� push
	 * dequeue: ���� s2�� ������� �ʴٸ� S2�κ��� ��
	 * 			����ִٸ� s1 ��� �׸��� s2�� �̵���Ų �� s2 �ֻ��� �׸��� ���ؼ� ���� 
	 */
	class QueueWithTwoStacks() {
		Stack stack1;
		Stack stack2;
		
		public QueueWithTwoStacks() {
			stack1 = new LLStack();
			stack2 = new LLStack();
		}
		
		public boolean isEmpty() {
			if(stack2.empty()) {
				while(!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
			
			return stack2.isEmpty();
		}
		
		public void enqueue(int data) {
			stack1.push(data);
		}
		
		public int dequeue() {
			if(!stack2.isEmpty()) {
				return stack2.pop();
			} else { 
				while(!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
				
			return stack2.pop();
		}	
	}
	
	/*
	 * #3. �� ���� ť�� ����ؼ� ȿ�������� ������ �����ϰ�, �� ���� ������ ���� �ð��� �м��϶�.
	 */
	
	/*
	 * #4. �����̴� â�� �ִ���
	 * 
	 * �迭 A[]�� ũ�Ⱑ w�� â�� �־ �迭�� �� �������κ��� ���������� �����δٰ� ����. â ���� w���� ���ڸ� �� �� �ִٰ� ��������.
	 * â�� �Ź� �� ���� ���������� �����δ�.
	 * �Է�: �� �迭 A[], â�� ũ�� w
	 * ���: b{i]�� a[i]���� a[i+w-1]������ �ִ� ���� �迭 b[]
	 * �䱸����: b[i]�� ���ϴ� ����ȭ�� ���
	 * 
	 * �ذ�å: ���� ť ���
	 */
	void MaxSlidingWindow(int a[], int n, int w, int b[]) {
		DoubleEndedQueue Q = new DoubleEndedQueue();
		for(int i = 0; i < w; i++) {
			while(!Q.isEmpty() && a[i] >= a[Q.QBack()])
				Q.PopBack();
			Q.PushBack(i);
		}
		
		for(int i = w; i < n; i++) {
			b[i - w] = a[Q.QFront()];
			while(!Q.isEmpty() && a[i] >= a[Q.QBack()])
				Q.PopBack();
			while(!Q.isEmpty() && Q.QFront() <= (i - w))
				Q.PopFront();
			Q.PushBack(i);
		}
		
		b[n - w] = a[Q.QFront()];
	}
	
}

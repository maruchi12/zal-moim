package queue;

import java.util.Stack;

public class Excercises {
	
	/*
	 *  #1. 큐인 Q의 항목들의 순서를 뒤집는 알고리즘을 제시하라. 큐에 액세스할 때 큐 ADT의 함수들만 이용해야 한다.
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
	 * #2. 두 개의 스택으로 큐를 구현하려면 어떻게 하는가?
	 * 
	 * enqueue: 스택 S1에 push
	 * dequeue: 스택 s2가 비어잇지 않다면 S2로부터 팝
	 * 			비어있다면 s1 모든 항목을 s2로 이동시킨 뒤 s2 최상위 항목을 팝해서 리턴 
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
	 * #3. 두 개의 큐를 사용해서 효율적으로 스택을 구현하고, 또 스택 연산의 수행 시간을 분석하라.
	 */
	
	/*
	 * #4. 움직이는 창의 최대합
	 * 
	 * 배열 A[]에 크기가 w인 창이 있어서 배열의 맨 왼쪽으로부터 오른쪽으로 움직인다고 하자. 창 안의 w개의 숫자만 볼 수 있다고 가정하자.
	 * 창은 매번 한 개씩 오른쪽으로 움직인다.
	 * 입력: 긴 배열 A[], 창의 크기 w
	 * 출력: b{i]가 a[i]에서 a[i+w-1]까지의 최대 값인 배열 b[]
	 * 요구사항: b[i]를 구하는 최적화된 방법
	 * 
	 * 해결책: 이중 큐 사용
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

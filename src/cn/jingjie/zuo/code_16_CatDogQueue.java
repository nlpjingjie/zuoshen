package cn.jingjie.zuo;

import java.util.LinkedList;
import java.util.Queue;


public class code_16_CatDogQueue {
	
	public static class Pet{
		private String type;
		
		public Pet(String type) {
			this.type = type;
		}
		
		public String GetPetType() {
			return this.type;
		}
	}
	
	public static class Dog extends Pet{
		public Dog() {
			super("dog");
		}
	}
	
	public static class Cat extends Pet{
		public Cat() {
			super("cat");
		}
	}
	
	// EnterPet类，给每个宠物加上数量标记
	public static class EnterPet{
		private Pet pet;
		private long count;
		
		public EnterPet(Pet pet, long count) {
			this.pet = pet;
			this.count = count;
		}
		
		public Pet getPet() {
			return this.pet;
		}
		
		public long getCount() {
			return this.count;
		}
		
		public String getEnterPetType() {
			return this.pet.GetPetType();
		}
	}
	
	// CatDogQueue类实现按顺序输出cat或dog的方法
	public static class CatDogQueue{
		private Queue<EnterPet> dogQueue;
		private Queue<EnterPet> catQueue;
		private long count;
		
		public CatDogQueue() {
			this.dogQueue = new LinkedList<>();
			this.catQueue = new LinkedList<>();
			this.count = 0;
		}
		
		// 将cat或者dog类的实例添加到队列中
		public void offer(Pet pet) {
			if(pet.GetPetType().equals("dog")) {
				dogQueue.offer(new EnterPet(pet, this.count++));
			}else if(pet.GetPetType().equals("cat")) {
				catQueue.offer(new EnterPet(pet, this.count++));
			}else {
				throw new RuntimeException("err, not cat or dog");
			}
		}
		
		// pollAll方法将宠物按进队列的顺序弹出
		public Pet pollAll() {
			if(!this.catQueue.isEmpty() && !this.dogQueue.isEmpty()) {
				if(this.dogQueue.peek().getCount() < this.catQueue.peek().getCount()) {
					return this.dogQueue.poll().getPet();
				}
				else {
					return this.catQueue.poll().getPet();
				}
			}
			else if(!this.catQueue.isEmpty()) {
				return this.catQueue.poll().getPet();
			}
			else if(!this.dogQueue.isEmpty()) {
				return this.dogQueue.poll().getPet();
			}
			else {
				throw new RuntimeException("catdogqueue is empty");
			}
		}
		
		public Dog pollDog() {
			if(!this.isDogQueueEmpty()) {
				return (Dog)this.dogQueue.poll().getPet();
			}else {
				throw new RuntimeException("dogqueue is empty");
			}
		}
		
		public Cat pollCat() {
			if(!this.isCatQueueEmpty()) {
				return (Cat)this.catQueue.poll().getPet();
			}else {
				throw new RuntimeException("catqueue is empty");
			}
		}
		
		private boolean isCatQueueEmpty() {
			// TODO Auto-generated method stub
			return this.catQueue.isEmpty();
		}

		private boolean isDogQueueEmpty() {
			// TODO Auto-generated method stub
			return this.dogQueue.isEmpty();
		}
		
		public boolean isEmpty() {
			return this.catQueue.isEmpty() && this.dogQueue.isEmpty();
		}
	}
	
	public static void main(String[] args) {
//		code_16_CatDogQueue outcatDogQueue = new code_16_CatDogQueue();
//		code_16_CatDogQueue.Dog d1 = outcatDogQueue.new Dog();
//		code_16_CatDogQueue.Dog d3 = outcatDogQueue.new Dog();
//		code_16_CatDogQueue.Dog d2 = outcatDogQueue.new Dog();
//		code_16_CatDogQueue.Cat c2 = outcatDogQueue.new Cat();
//		code_16_CatDogQueue.Cat c1 = outcatDogQueue.new Cat();
//		code_16_CatDogQueue.CatDogQueue cdq = outcatDogQueue.new CatDogQueue();
		CatDogQueue cdq = new CatDogQueue();
		Dog d1 = new Dog(); 
		Dog d2 = new Dog(); 
		Dog d3 = new Dog(); 
		Cat c1 = new Cat();
		Cat c2 = new Cat();
		cdq.offer(d3);
		cdq.offer(d2);
		cdq.offer(c2);
		cdq.offer(c1);
		cdq.offer(d1);
		while(!cdq.isEmpty()) {
			System.out.println(cdq.pollAll().GetPetType());
		}
//		System.out.println(cdq.count);
//		System.out.println(cdq.pollDog().GetPetType());
//		System.out.println(cdq.pollDog().GetPetType());
//		System.out.println(cdq.pollAll().GetPetType());
	}
}

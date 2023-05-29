package tp;

import java.util.*;

class GameObject {
	int x; //현재 x좌표
	int y; //현재 y좌표
	boolean visible; //GUI에서 표시되는지?
	public void run() {
		return;
	}
}

class Enemy extends GameObject {
	int velocity = 1;
	int health = 1000;
	int index = 0;
	int[][] road = new int[][] {
		{3,0},{3,1},{2,1},{1,1},{0,1},{0,2},{0,3},
		{1,3},{2,3},{3,3},{4,3},{4,4},{4,5},{3,5},
		{2,5},{1,5},{0,5},{0,6},{0,7},{0,8},{0,9},
		{1,9},{2,9},{2,8},{2,7},{3,7},{4,7},{4,8},
		{4,9}};
	Enemy() {
		this.health = 1000 + Board.round*100;
		this.visible = false;
	}
	void move(MainTower target) {
		if(index ==0)
		{
			this.x =  road[0][1] * 100 ;
			this.y = 500 - road[0][0] * 100;
			index = 1;

		}
		if( (this.x )== road[this.index][1]*100 && (this.y) == 500-road[this.index][0]*100)
		{
			this.index +=1;
		}
		if(index == 28)
		{
			this.attack(target);
			return;
		}
		this.x += (road[this.index][1] - road[this.index-1][1])  * this.velocity;
		this.y += (road[this.index][0] - road[this.index-1][0])  * this.velocity;
	}
	void attack(MainTower target)
	{
		target.health -= this.health;
		this.health = 0;
	}
}

class Bullet extends GameObject {
	int velocity;
	int objectx;
	int objecty;
	double direction; //rad형태로 바뀌겠죠.
	Bullet(int x,int y,int objectx,int objecty) {
		this.x = x;
		this.y = y;
		this.objectx = objectx;
		this.objecty = objecty;
	}
	void GetDirection() {
		
	}
	void move() {
		//Enemy와 비슷.
		//어떤 목표를 찍으면 그 방향으로 쭉 나아가게 됨.
	}
	boolean isHit() {
		if(x<0 || x>1000 || y<0 || y>500)
			return true;
		
		return false;
	}
}
class Tower extends GameObject {
	int atk = 50;//체력은 얼마나 깎을건지?
	int reload = 5; //몇 Cycle마다 한번 쏘는지?
	int target = -1; //ArrayList의 몇번째 Enemy를 쏠건지?
	double radian;
	int cnt = 0;
	Tower(int x,int y) {
		this.x = x;
		this.y = y;
		this.visible = false;
	}
	
	void SetDirection() {
		
	}
	
	void Shoot() {
		
	}
}


class MainTower extends GameObject{
	int health;
	int x;
	int y;
	MainTower(int health)
	{
		this.health = health;
	}
}

package report.kimseunghun.r0013;

import java.util.List;

import com.google.common.collect.Lists;

public class ListExam2 {
	public void arryToListWithGuava() {
		Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
		List<Integer> targetList = Lists.newArrayList(sourceArray);
	}

	public static void main(String[] args) {
		ListExam2 le = new ListExam2();
		le.arryToListWithGuava();
	}
}
//mysql jdbc jar douwnload
//select * from user;
//
//insert into user
//value('test1', 'pass1', 'name1','30','12345','서울 강서구 등촌1동','보람3차아파트 101동 301호');
//insert into user
//value('test2', 'pass2', 'name2','30','12345','서울 강서구 등촌1동','보람3차아파트 101동 301호');
//insert into user
//value('test3', 'pass3', 'name3','30','12345','서울 강서구 등촌1동','보람3차아파트 101동 301호');
//insert into user
//value('test4', 'pass4', 'name4','30','12345','서울 강서구 등촌1동','보람3차아파트 101동 301호');
//insert into user
//value('test5', 'pass5', 'name5','30','12345','서울 강서구 등촌1동','보람3차아파트 101동 301호');
//insert into user
//value('test6', 'pass6', 'name6','30','12345','서울 강서구 등촌1동','보람3차아파트 101동 301호');
//insert into user
//value('test7', 'pass7', 'name7','30','12345','서울 강서구 등촌1동','보람3차아파트 101동 301호');
//insert into user
//value('test8', 'pass8', 'name8','30','12345','서울 강서구 등촌1동','보람3차아파트 101동 301호');
//insert into user
//value('test9', 'pass9', 'name9','30','12345','서울 강서구 등촌1동','보람3차아파트 101동 301호');
//insert into user
//value('test10', 'pass10', 'name10','30','12345','서울 강서구 등촌1동','보람3차아파트 101동 301호');
//
//
//update user
//set address1='서울 강남구 역삼동'
//where id='test3';
//
//update user
//set address1='서울 영등포구 여의도동'
//where id='test5';
//
//update user
//set address1='서울 강서구 화곡동'
//where address1 like '%등촌1동%';
//
//update user
//set password='pass'
//where password='pass1'
//or
//password='pass2';
//
//select * from user
//where address1 like '%화곡동%'
//and password='pass';
//;
//select * from user;
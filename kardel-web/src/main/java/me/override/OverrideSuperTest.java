package me.override;

public class OverrideSuperTest{

	public static void main(String[] args) {

		OverrideSubT testSub = new OverrideSubT();
		System.out.println(judgeRealClass(testSub));
	}

	public static int judgeRealClass(OverrideSuper b){

		return b instanceof OverrideSub ?((OverrideSub)b).a: b instanceof OverrideSubT ?((OverrideSubT)b).a: b.a;
	}
}

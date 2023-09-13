package model;

import java.io.Serializable;

public class Quiz implements Serializable{
	private int pkey;
	private String problem;
	private String ans_a;
	private String ans_b;
	private String ans_c;
	private String answer;
	private String aitem;
	private String genre;
	private String ans;
	private String hit_out;

	public Quiz() {}

	public Quiz(int pkey, String problem, String ans_a, String ans_b, String ans_c, String answer, String aitem, String genre, String ans, String hit_out) {
		this.pkey = pkey;
		this.problem = problem;
		this.ans_a = ans_a;
		this.ans_b = ans_b;
		this.ans_c = ans_c;
		this.answer = answer;
		this.aitem = aitem;
		this.genre = genre;
		this.ans = ans;
		this.hit_out = hit_out;
	}

	public int getPkey() {return pkey;}
	public String getProblem() {return problem;}
	public String getAns_a() {return ans_a;}
	public String getAns_b() {return ans_b;}
	public String getAns_c() {return ans_c;}
	public String getAnswer() {return answer;}
	public String getAitem() {return aitem;}
	public String getGenre() {return genre;}
	public String getAns() {return ans;}
	public String getHit_out() {return hit_out;}
}

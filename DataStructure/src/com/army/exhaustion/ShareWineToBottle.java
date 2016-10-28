package com.army.exhaustion;

/**
 * 泊松分酒：穷举法<br>
 * 规则：<br>
 * 1. 大瓶子只能倒入中瓶子<br>
 * 2. 中瓶子只能倒入小瓶子<br>
 * 3. 小瓶子只能倒入大瓶子<br>
 * 4. 小瓶子只有在已经装满的情况下才能倒入大瓶子<br>
 * 5. 若小瓶子被倒空，则无论中瓶子是否满，应马上从中瓶子倒入小瓶子<br>
 * 
 * @author dai
 *
 */
public class ShareWineToBottle {
	private int a = 12;
	private int b = 8;
	private int c = 5;
	private int target = 6;

	public void shareWine(int a1, int b1, int c1) {
		System.out.println("a=" + a1 + "\tb=" + b1 + "\tc=" + c1);
		if (a1 == target || b1 == target || c1 == target) {
			return;
		}
		if (b1 != 0 && c1 != c) {
			if (b1 + c1 > c) {// 把水从b1倒到c1，c1满了，b1还有剩余的
				shareWine(a1, b1 - (c - c1), c);
			} else {
				shareWine(a1, 0, b1 + c1);
			}
		} else if (c1 == c) {
			if (a1 + c1 < a) {// 把水从c1倒到a1，c1倒光了，a1还没满
				shareWine(a1 + c1, b1, 0);
			} else {
				shareWine(a, b1, c1 - (a - a1));
			}
		} else if (b1 == 0) {
			if (a1 + b1 > b) {// 把水从a1倒到b1，b1满了，a1还有剩
				shareWine(a1 - b, b, c1);
			} else {
				shareWine(0, a1 + b1, c1);
			}
		}
	}

	public static void main(String[] args) {
		ShareWineToBottle bottle = new ShareWineToBottle();
		bottle.shareWine(12, 0, 0);
	}

}

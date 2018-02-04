package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BlackJack {
	public static void main(String args[]) throws IOException{
		int myCard_1 = (int)(Math.random()*10)+1;
		int myCard_2 = (int)(Math.random()*10)+1;
		/**
		 *	カードの合計
		 */
		int total = myCard_1 + myCard_2 ;
		/**
		 *	最初の手を出力する
		 */
		System.out.println("1枚目のカード : " + myCard_1);
		System.out.println("2枚目のカード : "  + myCard_2);
		System.out.println("あなたの手 : "+ total);
		/**
		 *	追加で受け取るカードを格納するためにArrayListを用意する
		 */
		ArrayList<Integer> array = new ArrayList<Integer>();

		/**
		 *	追加で受け取るカードの制限回数なしと想定する
		 */
		for(int i = 0 ; ; i++) {
			/**
			 *	追加で受け取ったカードをramdomメソッドで生成
			 */
			int addCard  = (int)(Math.random()*10)+1;
			/**
			 *	addメソッドで追加で受け取ったカードをArrayListに格納する
			 */
			array.add(addCard);
			/**
			 *	追加で受け取ったカードをgetメソッドでArrayListから取り出して合計点数に足す
			 */
			total = total + array.get(i);
			System.out.println("更にカードを受け取りますか？");
			System.out.println("HIT or STAND を入力してEnter ");
			/**
			 *	コンソール画面で入力された値をreturnするメソッド
			 */
			String resultConsolVal = getConsolVal();

			/**
			 *	HITを選択し、カードを受け取った場合のコメントを出力
			 */
			if (resultConsolVal.equals("HIT")) {
				System.out.println("HIT!!" + "\n");
				System.out.println("もう1枚カードを受け取ります");
				System.out.println(i + 3 + "枚目のカード : " + addCard);
				/**
				 *	合計点数を出力する
				 */
				System.out.println("あなたの合計点数 : " + total );
				/**
				 *	合計点数別のコメント用メソッドを呼び出す
				 */
				String resultComment = BlackJack.getTotal(total);
				System.out.println(resultComment);
					/**
					 *	合計点数が21以上なら終了する
					 */
					if (total >= 21) {
						break;
					}
			/**
			 *	STANDを選択し、カードを受け取らなかった場合の合計点数を出力
			 */
			} else if(resultConsolVal.equals("STAND")){
				System.out.println("STAND!!");
				System.out.println("あなたの合計点数 : " + (total - addCard));
				/**
				 *	合計点数別のコメント用メソッドを呼び出す
				 */
				String resultComment = BlackJack.getTotal(total - addCard);
				System.out.println(resultComment);
				break;
			} else {
				System.out.println("不正行為は禁止されています");
				break;
			}
		}
	}

	/**
	 *	コンソール画面で入力された値を返すメソッド
	 */
	public static String getConsolVal() throws IOException {
		String val;
		/**
		 *	コンソール画面の入力文字を読み込み、valに代入する
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		val = br.readLine();
		return val;
	}

	/**
	 *	合計点数によって出力するコメントを判定するメソッド
	 */
	public static String getTotal(int subtotal) {
		String comment;
		if (subtotal == 21) {
			comment = "BlackJack!!";
		} else if (subtotal > 21) {
			comment = "Pig!!";
		} else if ((subtotal >= 16)&&(subtotal <= 20)) {
			comment = "STAND!!";
		} else {
			comment = "HIT!!";
		}
		return comment;
	}
}
package test;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/CardTest2")
public class CardTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public CardTest2() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 受信内容の文字コード
		response.setContentType("text/html; charset=UTF-8"); // 送信内容の文字コード
		// 受け取った内容を変数に入れる
		String suit = request.getParameter("suit");
		String number[] = request.getParameterValues("number");
		String color = request.getParameter("color");
		String query = request.getParameter("query");
		// コンソールへの出力
		System.out.println("--------");
		List<String> numberlist = null;
		if (number == null) {
			numberlist = new ArrayList<>();
		} else {
			numberlist = Arrays.asList(number);
		}
		System.out.println(numberlist);
		System.out.println("color=" + color);
		System.out.println("query=" + query);
		// ブラウザへの出力
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(suit);
		out.println("<hr>");
		out.println(numberlist);
		out.println("<hr>");
		out.println(color);
		out.println("<hr>");
		out.println(query);
		out.println("<hr>");

		boolean suitFlag[] = new boolean[53];
		boolean numberFlag[] = new boolean[53];

		// 記号による選別
		if (suit.equals("all")) {
			for (int i=1; i<=52; i++) {
				suitFlag[i] = true;
			}
		} else if (suit.equals("spade")) {
			for (int i=1; i<=13; i++) {
				suitFlag[i] = true;
			}
		} else if (suit.equals("heart")) {
			for (int i=14; i<=26; i++) {
				suitFlag[i] = true;
			}
		}else if (suit.equals("diamond")) {
			for (int i=27; i<=39; i++) {
				suitFlag[i] = true;
			}
		}else if (suit.equals("club")) {
			for (int i=40; i<=52; i++) {
				suitFlag[i] = true;
			}
		}
		if(numberlist.contains("0")) {
			for (int i=1; i<=52; i++) {
				numberFlag[i] = true;
			}
		}else if(numberlist.contains("1")) {
		    for(int i=0; i<4; i++) {
		        numberFlag[1+13*i] = true;
		    }
		}
		else if(numberlist.contains("2")) {
		    for(int i=0; i<4; i++) {
		        numberFlag[2+13*i] = true;
		    }
		}
		else if(numberlist.contains("3")) {
		    for(int i=0; i<4; i++) {
		        numberFlag[3+13*i] = true;
		    }
		}
		else if(numberlist.contains("4")) {
		    for(int i=0; i<4; i++) {
		        numberFlag[4+13*i] = true;
		    }
		}
		else if(numberlist.contains("5")) {
		    for(int i=0; i<4; i++) {
		        numberFlag[5+13*i] = true;
		    }
		}
		else if(numberlist.contains("6")) {
		    for(int i=0; i<4; i++) {
		        numberFlag[6+13*i] = true;
		    }
		}
		else if(numberlist.contains("7")) {
		    for(int i=0; i<4; i++) {
		        numberFlag[7+13*i] = true;
		    }
		}
		else if(numberlist.contains("8")) {
		    for(int i=0; i<4; i++) {
		        numberFlag[8+13*i] = true;
		    }
		}
		else if(numberlist.contains("9")) {
		    for(int i=0; i<4; i++) {
		        numberFlag[9+13*i] = true;
		    }
		}
		else if(numberlist.contains("10")) {
		    for(int i=0; i<4; i++) {
		        numberFlag[10+13*i] = true;
		    }
		}
		else if(numberlist.contains("11")) {
		    for(int i=0; i<4; i++) {
		        numberFlag[11+13*i] = true;
		    }
		}
		else if(numberlist.contains("12")) {
		    for(int i=0; i<4; i++) {
		        numberFlag[12+13*i] = true;
		    }
		}
		else if(numberlist.contains("13")) {
		    for(int i=0; i<4; i++) {
		        numberFlag[13+13*i] = true;
		    }
		}


		// 数字による選別
		out.println(numberlist.contains("1"));
		out.println("<br>");

		// 色による選別
		// カードの表示
		for (int i=1; i<=52; i++) {
			if (suitFlag[i]==true&& numberFlag[i]==true) {
				String filename = "cards/" + i + ".png";
				out.printf("<img src=\"%s\" width=\"100\" height=\"150\">\n", filename);
			}
		
		}
		out.println("</html>");
	}
} 
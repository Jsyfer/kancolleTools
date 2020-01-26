package servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jpa.UnitDetails;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/fleetplan")
public class FleetPlanServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
        if(session.getAttribute("userId") == null){
            request.getRequestDispatcher("WEB-INF/jpa/login.jsp").forward(request,response);
        }
        //开启JPA接口
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //获取当前用户所有单位
        List<Object[]> rows = em.createQuery("SELECT u.id,u.name,s.id,t.name,tg.id,tg.name,tg.color,tg.pic "
        		+ "FROM UserUnit uu "
        		+ "JOIN uu.tag tg "
        		+ "JOIN uu.unit u "
        		+ "JOIN uu.unit.type t "
        		+ "JOIN uu.unit.status s "
        		+ "WHERE uu.user.id = :userid")
        		.setParameter("userid",session.getAttribute("userId"))
        		.getResultList();
        //将取得单位分别存入未使用及已使用列表中
        List<UnitDetails> unitList = new ArrayList<UnitDetails>();
        List<UnitDetails> unitListUsed = new ArrayList<UnitDetails>();
        for(Object[] row : rows) {
        	if((int)row[4] == 0) {
        	unitList.add(new UnitDetails(
        			(int)row[0],
        			(String)row[1],
        			(int)row[2],
        			(String)row[3],
        			(int)row[4],
        			(String)row[5],
        			(String)row[6],
        			(String)row[7]
        			));
        	}else {
        		unitListUsed.add(new UnitDetails(
            			(int)row[0],
            			(String)row[1],
            			(int)row[2],
            			(String)row[3],
            			(int)row[4],
            			(String)row[5],
            			(String)row[6],
            			(String)row[7]
            		));
        	}
        }
        //确定执行语句
        em.getTransaction().commit();
        //传递两组舰船列表   
        request.setAttribute("unitList", unitList);
        request.setAttribute("unitListUsed", unitListUsed);
        //跳转至对应的显示页面
        request.getRequestDispatcher("WEB-INF/jpa/fleetplan.jsp").forward(request,response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
    }


}

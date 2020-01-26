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

import jpa.Unit;
import jpa.UnitDetails;
import jpa.User;
import jpa.UserUnit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addunit")
public class AddUnitServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("userId") == null){
            request.getRequestDispatcher("WEB-INF/jpa/login.jsp").forward(request,response);
        }
		//开启JPA接口
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //显示全部备选单位
        List<Object[]> rows = em.createQuery("SELECT a.id,a.name,c.id,b.name FROM Unit a JOIN a.type b JOIN a.status c")
        		.getResultList();
        //将取得的结果列表存入新对象中
        List<UnitDetails> unitList = new ArrayList<UnitDetails>(rows.size());
        for(Object[] row : rows) {
        	unitList.add(new UnitDetails((int)row[0],(String)row[1],(int)row[2],(String)row[3]));
        }
        //确定语句
        em.getTransaction().commit();
        //传递获取的结果列表
        request.setAttribute("unitList", unitList);
        //跳转至对应的显示页面
	    request.getRequestDispatcher("/WEB-INF/jpa/addunit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("userId") == null){
            request.getRequestDispatcher("WEB-INF/jpa/login.jsp").forward(request,response);
        }
		//开启JPA接口
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
        	//获取当前用户对象
        	User u = em.createQuery("SELECT u FROM User u WHERE u.id=:uid",User.class)
        		.setParameter("uid",session.getAttribute("userId")).getSingleResult();
        	//从页面表单获取要添加的单位列表
        	String unitToAdd[] = request.getParameterValues("unitCheck");
        	//遍历列表中的每一艘船添加至用户列表
        	for(String uta: unitToAdd) {
        		Unit ship = em.createQuery("SELECT ship FROM Unit ship WHERE ship.id=:sid",Unit.class)
        			.setParameter("sid",Integer.parseInt(uta)).getSingleResult();
        		UserUnit uu = new UserUnit(ship,u);
        		em.persist(uu);
        	}
        	//确定语句
        	em.getTransaction().commit();
        }finally {
			em.close();
		}
		doGet(request, response);
	}
}

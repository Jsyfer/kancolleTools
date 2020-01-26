package servlet;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class MyFleetServlet
 */
@WebServlet("/myfleet")
public class MyFleetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFleetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
        if(session.getAttribute("userId") == null){
            request.getRequestDispatcher("WEB-INF/jpa/login.jsp").forward(request,response);
        }
        //开启JPA接口
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //显示当前用户的全部单位
        List<Unit> unitList = em.createQuery("SELECT b FROM UserUnit a JOIN a.unit b WHERE a.user.id = :uid ",Unit.class)
        		.setParameter("uid", session.getAttribute("userId")).getResultList();
        //确定执行语句
        em.getTransaction().commit();
        //传递获取的结果列表
        request.setAttribute("unitList", unitList);
        //跳转至对应的显示页面
        request.getRequestDispatcher("WEB-INF/jpa/fleet.jsp").forward(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

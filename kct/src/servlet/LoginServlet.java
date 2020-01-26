package servlet;

import jpa.Type;
import jpa.Status;
import jpa.Tag;
import jpa.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if(session.getAttribute("userId") == null){
            request.getRequestDispatcher("WEB-INF/jpa/login.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("WEB-INF/jpa/home.jsp").forward(request,response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        // get user name and password from user input
        String u_name = request.getParameter("u_name");
        String u_pass = request.getParameter("u_pass");
        //check from database
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            //取得所有舰船类型、改造状态、贴条个数，并存入session
            List<Type> typeList = em.createQuery("SELECT t FROM Type t",Type.class).getResultList();
            session.setAttribute("typeList",typeList);
            List<Status> statusList = em.createQuery("SELECT s FROM Status s",Status.class).getResultList();
            session.setAttribute("statusList", statusList);
            List<Tag> taglist = em.createQuery("SELECT tg FROM Tag tg ORDER BY tg.id DESC",Tag.class)
            		.setMaxResults(1).getResultList();
            session.setAttribute("tagNum", taglist.get(0).getId());
            //取得用户信息
            List<User> list = em.createQuery("SELECT u FROM User u WHERE u.uName = :uid AND u.uPass = :pwd", User.class)
                    .setParameter("uid", u_name).setParameter("pwd", u_pass).getResultList();
            //确认语句
            em.getTransaction().commit();
            User u = null;
            for (User user : list) {
                u = user;
            }
            if(u != null){
                session.setAttribute("userId",u.getId());
                request.getRequestDispatcher("/WEB-INF/jpa/home.jsp").forward(request,response);
            }else{
                response.sendError(403);
            }
        }finally {
            em.close();
        }
    }
}
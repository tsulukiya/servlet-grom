import Entity.Item;
import ItemController.ItemController;
import ItemDAO.ItemDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet(urlPatterns = "/test")
public class MyServlet extends HttpServlet {
    private ItemController itemController = new ItemController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Item item = objectMapper.readValue(new InputStreamReader(req.getInputStream()), Item.class);
        resp.getWriter().println(itemController.findById(item.getId()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Item item = objectMapper.readValue(new InputStreamReader(req.getInputStream()), Item.class);
        System.out.println(itemController.save(item));
        resp.getWriter().println("Save in DataBase is done");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Item item = objectMapper.readValue(new InputStreamReader(req.getInputStream()), Item.class);
        System.out.println(itemController.update(item));
        resp.getWriter().println("Update in DataBase is done");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Item item = objectMapper.readValue(new InputStreamReader(req.getInputStream()), Item.class);
        System.out.println(itemController.delete(item.getId()));
        resp.getWriter().println("Delete object in DataBase is done");
    }
}

package controller;

import entity.BinaryTree;
import entity.List;
import service.Service;
import service.ServiceFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DNAPC on 14.11.2017.
 */
public class Controller extends HttpServlet {

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Service service = serviceFactory.getService();
        List list = service.getList(req.getParameter("method"));
        String[] values =(req.getParameter("values")).trim().split(" +");

        list.fill(service.toIntegerArray(values));

        BinaryTree binaryTree = new BinaryTree(list);
        setByPassTreeAttributes(binaryTree,req,resp);

        req.getRequestDispatcher("result.jsp").forward(req,resp);
    }

    private void setByPassTreeAttributes(BinaryTree binaryTree, HttpServletRequest req, HttpServletResponse resp){
        StringBuilder line = new StringBuilder();
        binaryTree.inOrderTraverseTree(line, binaryTree.getRoot());
        req.setAttribute("inOrder", line);

        line = new StringBuilder();
        binaryTree.preOrderTraverseTree(line, binaryTree.getRoot());
        req.setAttribute("preOrder", line);

        line = new StringBuilder();
        binaryTree.postOrderTraverseTree(line, binaryTree.getRoot());
        req.setAttribute("postOrder", line);
    }
}

package admin.app.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import admin.app.dto.Genre;
import admin.app.dto.Movie;
import admin.app.dto.Person;

/**
 * Servlet implementation class Add
 */
@WebServlet("/adminAdd")
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// location to store file uploaded
	private static final String UPLOAD_DIRECTORY = "admin/upload";

	// upload settings
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/admin/pages/add.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// =============== uploading the image and video ===============

		List<String> dataIndexs = new ArrayList<String>();
		List<String> dataValues = new ArrayList<String>();

		Hashtable<String, String> uploadedFiles = new Hashtable<String, String>();

		// checks if the request actually contains upload file
		if (!ServletFileUpload.isMultipartContent(request)) {
			// if not, we stop here
			PrintWriter writer = response.getWriter();
			writer.println("Error: Form must has enctype=multipart/form-data.");
			writer.flush();
			return;
		}

		// configures upload settings
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// sets memory threshold - beyond which files are stored in disk
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// sets temporary location to store files
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);

		// sets maximum size of upload file
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// sets maximum size of request (include file + form data)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// constructs the directory path to store upload file
		// this path is relative to application's directory
		String uploadPath = getServletContext().getRealPath("")
				+ File.separator + UPLOAD_DIRECTORY;

		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// parses the request's content to extract file data
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);
			if (formItems != null && formItems.size() > 0) {
				// iterates over form's fields
				for (FileItem item : formItems) {
					// processes only fields that are not form fields
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						String filePath = uploadPath + File.separator
								+ fileName;
						File storeFile = new File(filePath);
						// saves the file on disk
						item.write(storeFile);
						System.out
								.println("Upload has been done successfully!");

						uploadedFiles.put(item.getFieldName(), filePath);

					} else {

						dataIndexs.add(item.getFieldName());
						dataValues.add(item.getString());
					}
				}

			}
		} catch (Exception ex) {
			request.setAttribute("message",
					"There was an error: " + ex.getMessage());
		}

		// =========== Finished Upload image and video ===========

		System.out.println(dataIndexs);
		Movie movie = new Movie();

		movie.setMovieName(dataValues.get(dataIndexs.indexOf("moviename")));
		movie.setReleasedDate(dataValues.get(dataIndexs.indexOf("releaseddate")));
		movie.setPgRating(dataValues.get(dataIndexs.indexOf("pgrating")));
		movie.setDuration(dataValues.get(dataIndexs.indexOf("duration")));
		movie.setSummary(dataValues.get(dataIndexs.indexOf("content")));
		movie.setImageLink(uploadedFiles.get("image"));
		movie.setDownloadLink(uploadedFiles.get("video"));

		int dSize = Collections.frequency(dataIndexs, "dfirstname");
		int wSize = Collections.frequency(dataIndexs, "wfirstname");
		int sSize = Collections.frequency(dataIndexs, "afirstname");
		int gSize = Collections.frequency(dataIndexs, "genres");
		
		Person[] directors = new Person[dSize];
		Person[] writers = new Person[wSize];
		Person[] stars = new Person[sSize];
		Genre[] genres = new Genre[gSize];
		
		for(int i=0;i< dSize; i++)
		{
			
		}
		
		System.out.println(dSize);
		System.out.println(wSize);
        System.out.println(sSize);
        System.out.println(gSize);
        
        
		

		try {

			movie = new Movie();

			// appDao = AppDaoFactory.getAppDao();
			// appDao.addMovie(movie, directors, writers, stars, genres);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("adminAdd");
		}

	}

}

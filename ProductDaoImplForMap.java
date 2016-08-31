package com.flp.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;


public class ProductDaoImplForMap implements IProductDao {

	// Central Repository
	Map<Integer, Product> products = new HashMap<Integer, Product>();

	// MySQL repository
	

	

	public List<Category> getAllCategory() {

		List<Category> categories = new ArrayList<Category>();
		/*categories.add(new Category(1, "Electronics", "Electronic Items"));
		categories.add(new Category(2, "Clothing", "All Cloth Varity"));
		categories.add(new Category(3, "Health&Care", "Health And Hospitality"));
		categories.add(new Category(4, "HouseHolds", "HouseHold Items"));
		categories.add(new Category(5, "Sports", "Games related Items"));*/
	
		Connection conn= getMySqlConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="select * from category;";
		
		
		
		try {
			stmt=conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){  
			Category category=new Category();
				category.setCategory_Id(rs.getInt("category_Id"));
				category.setCategory_Name(rs.getString("category_Name"));
				category.setDescription(rs.getString("description"));
				categories.add(category);
		
				}  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				if(stmt!=null)
				stmt.close();
				if(conn!=null)
					conn.close();
				if (rs!=null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return categories;
	}

	
	
	public List<SubCategory> getAllSubCategory() {
		List<Category> categories =getAllCategory();
		List<SubCategory> subcategories = new ArrayList<SubCategory>();
		/*subcategories.add(new SubCategory(101, "Mobile", new Category(1, "Electronics", "Electronic Items")));
		subcategories.add(new SubCategory(102, "PowerBank", new Category(1, "Electronics", "Electronic Items")));
		subcategories.add(new SubCategory(103, "Data Storage", new Category(1, "Electronics", "Electronic Items")));

		subcategories.add(new SubCategory(201, "T-Shirt", new Category(2, "Clothing", "All Cloth Varity")));
		subcategories.add(new SubCategory(202, "Kurta", new Category(2, "Clothing", "All Cloth Varity")));
		subcategories.add(new SubCategory(203, "Saree", new Category(2, "Clothing", "All Cloth Varity")));
		subcategories.add(new SubCategory(204, "Kids Wear", new Category(2, "Clothing", "All Cloth Varity")));

		subcategories
				.add(new SubCategory(301, "Diabetic Shoes", new Category(3, "Health&Care", "Health And Hospitality")));
		subcategories
				.add(new SubCategory(302, "Diabetic Metre", new Category(3, "Health&Care", "Health And Hospitality")));
		subcategories.add(
				new SubCategory(303, "Blood Pressure Metre", new Category(3, "Health&Care", "Health And Hospitality")));

		subcategories.add(new SubCategory(401, "Dining Sets", new Category(4, "HouseHolds", "HouseHold Items")));
		subcategories.add(new SubCategory(402, "Cooker", new Category(4, "HouseHolds", "HouseHold Items")));
		subcategories.add(new SubCategory(403, "Knife", new Category(4, "HouseHolds", "HouseHold Items")));
		subcategories.add(new SubCategory(404, "Glasses", new Category(4, "HouseHolds", "HouseHold Items")));

		subcategories.add(new SubCategory(501, "Cricket Bat", new Category(5, "Sports", "Games related Items")));
		subcategories.add(new SubCategory(502, "Cricket Ball", new Category(5, "Sports", "Games related Items")));
		subcategories.add(new SubCategory(503, "Hockey bat", new Category(5, "Sports", "Games related Items")));
		subcategories.add(new SubCategory(504, "Hockey Ball", new Category(5, "Sports", "Games related Items")));
		subcategories.add(new SubCategory(505, "Volley Ball", new Category(5, "Sports", "Games related Items")));
*/
		Category category=null;
		String sql="select * from SubCategory;";
		
		PreparedStatement stmt=null;
		Connection conn=getMySqlConnection();
		ResultSet rs=null;;
		try {
			stmt=conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){  
				SubCategory subcategory =new SubCategory();
				subcategory.setSub_category_Id(rs.getInt("sub_category_Id"));
				subcategory.setSub_category_Name(rs.getString("sub_category_Name"));
				int category_Id=rs.getInt("category_Id");
				for(Category c:categories)
				{
					if(c.getCategory_Id()==category_Id)
						subcategory.setCategory(c);
				}
				
				 subcategories.add(subcategory);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				if(stmt!=null)
				stmt.close();
				if(conn!=null)
					conn.close();
				if (rs!=null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		return subcategories;
	}

	public List<Supplier> getAllSuppliers() {

		List<Supplier> suppliers = new ArrayList<Supplier>();
		/*suppliers.add(new Supplier(111, "Tom", "Jerry", "North Avvenue", "Chennai", "Tamil Nadu", "600041", "6576575"));
		suppliers.add(
				new Supplier(222, "Jack", "Thomson", "South Avvenue", "Chennai", "Tamil Nadu", "600341", "78987978"));
		suppliers
				.add(new Supplier(333, "Kamal", "Emi", "West Avvenue", "Chennai", "Tamil Nadu", "600001", "787665765"));
		suppliers.add(new Supplier(444, "Annie", "Kenn", "EAST Avvenue", "Pune", "Maharastra", "600121", "5464565645"));
		suppliers.add(new Supplier(555, "Vimal", "Desai", "7th Avvenue", "Pune", "Maharastra", "600121", "87686787"));
		suppliers.add(new Supplier(666, "Bimal", "Singh", "12th Avvenue", "Pune", "Maharastra", "600121", "12456767"));
	*/
		String sql="select * from Supplier;";
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Connection conn=getMySqlConnection();
		try {
			stmt=conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){  
				
				Supplier supplier=new Supplier();
			supplier.setSupplierId(rs.getInt("supplierId"));

			supplier.setFirstName(rs.getString("firstName"));
			supplier.setLastName(rs.getString("lastName"));
			supplier.setAddress(rs.getString("address"));
			supplier.setCity(rs.getString("city"));
			supplier.setState(rs.getString("state"));
			supplier.setPincode(rs.getString("pincode"));
			supplier.setContactno(rs.getString("contactno"));
			suppliers.add(supplier);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
			try {
				if(stmt!=null)
				stmt.close();
				if(conn!=null)
					conn.close();
				if (rs!=null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return suppliers;
	}

	@SuppressWarnings("deprecation")
	public List<Discount> getAllDiscounts() {
		List<Discount> discounts = new ArrayList<Discount>();
		/*discounts
				.add(new Discount(123, "Mega Offer", "Mega offer From Jan to Feb", 12.4, new Date(2009 - 1900, 4, 23)));
		discounts.add(new Discount(333, "Dewali Offer", "Dewali offer ", 12.4, new Date(2018 - 1900, 4, 23)));
		discounts.add(new Discount(678, "New Year Offer", "New Year offer ", .50, new Date(2020 - 1900, 4, 23)));
		discounts.add(new Discount(1234, "X'Mas Offer", "Xmas offer ", .55, new Date(2019 - 1900, 4, 23)));
		discounts.add(new Discount(340, "Pongal Offer", "Pongal offer ", 12.78, new Date(2017 - 1900, 4, 23)));
*/
		
		
		String sql="select * from Discount;";
		PreparedStatement stmt=null;
		Connection conn=getMySqlConnection();
		ResultSet rs=null;	
		try {
			stmt=conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){  
				Discount discount=new Discount();	
				discount.setDiscountId(rs.getInt("discountId"));
				discount.setDiscountName(rs.getString("discountName"));	
				discount.setDescription(rs.getString("description"));
				discount.setDiscount_percentage(rs.getDouble("discount_percentage"));
				discount.setValidThru(rs.getDate("validThru"));
				discounts.add(discount);
					
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				if(stmt!=null)
				stmt.close();
				if(conn!=null)
					conn.close();
				if (rs!=null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return discounts;
	}

	public void addProduct(Product product) {
		
	

		String sql1 = "insert into product values(?,?,?,?,?,?,?,?,?,?,?)";
		String sql2 = "insert into productdiscount values(?,?)";
		Connection conn=getMySqlConnection();
		PreparedStatement stmt= null;
		PreparedStatement pd= null;
		PreparedStatement ps1= null;
		try {
			
			stmt=conn.prepareStatement(sql1);
			ps1=conn.prepareStatement(sql2);
			stmt.setInt(1, product.getProductId());
			stmt.setString(2, product.getProductName());
			stmt.setString(3, product.getDescription());
			stmt.setDate(4, new java.sql.Date(product.getManufacturing_date().getTime()));
			stmt.setDate(5, new java.sql.Date(product.getExpiry_date().getTime()));
			stmt.setDouble(6, product.getMax_retail_price());
			stmt.setInt(7, product.getCategory().getCategory_Id());
			stmt.setInt(8, product.getSubCategory().getSub_category_Id());
			stmt.setInt(9, product.getSupplier().getSupplierId());
			stmt.setInt(10, product.getQuantity());
			stmt.setFloat(11, product.getRatings());
			int rowInserted = stmt.executeUpdate();
			pd = conn.prepareStatement("select *from product");
			ResultSet rs = pd.executeQuery();
			int productId = 0;
			while (rs.next()) {
				productId = rs.getInt(1);
			}

			List<Discount> discounts = product.getDiscounts();
			for (Discount discount : discounts) {
				ps1.setInt(1, productId);
				ps1.setInt(2, discount.getDiscountId());
				ps1.executeUpdate();

			}
			System.out.println(rowInserted + " product inserted " );

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			try {
				if(stmt!=null ||pd==null)
				stmt.close();
				stmt.close();
				if(conn!=null)
					conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Map<Integer, Product> getAllProducts() {
		

		return null;
	}



	@Override
	public List<Product> getAllProducts1() {
		
		List<Product> products=new ArrayList<Product>();
		
		
		String sql="select * from product;";
		Connection conn=getMySqlConnection();
		PreparedStatement pst1= null;
		PreparedStatement pst2= null;
		ResultSet rs;	
		try {
			pst1=conn.prepareStatement(sql);
			rs = pst1.executeQuery();
			while(rs.next()){  
				Product product=new Product();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setDescription(rs.getString(3));
			    product.setManufacturing_date(rs.getDate(4));
			    product.setExpiry_date(rs.getDate(5));
			    product.setMax_retail_price(rs.getDouble(6));
			   
			    int categoryId=rs.getInt(7);
			    List<Category> categories=getAllCategory();
			    for(Category c:categories)
			    {
			    	if(c.getCategory_Id()==categoryId)
			    		product.setCategory(c);
			    }
			    
			    int subCategoryId=rs.getInt(8);
			    List<SubCategory> subCategories=getAllSubCategory();
			    for(SubCategory subcategory:subCategories)
			    {
			    	if(subcategory.getSub_category_Id()==subCategoryId)
			    		product.setSubCategory(subcategory);
			    }
			   
			    int supplierId=rs.getInt(9);
			    List<Supplier> suppliers=getAllSuppliers();
			    for(Supplier supplier:suppliers)
			    {
			    	if(supplier.getSupplierId()==supplierId)
			    		product.setSupplier(supplier);
			    }
			    
			    String sql1="select * from productdiscount where productId=?;";
				pst2=getMySqlConnection().prepareStatement(sql1);
				pst2.setInt(1, product.getProductId());
				List<Discount> discounts=new ArrayList<Discount>();
				ResultSet rs1;	
				
			    rs1=  pst2.executeQuery();
			    while(rs1.next()){ 
			    	
			    	int discountId=rs1.getInt(2);
				   Discount discount=new Discount();
				   for(Discount d:getAllDiscounts())
				   {
					   if(d.getDiscountId()==discountId)
						   discounts.add(d);
						   
				   }
				   product.setDiscounts(discounts); 
			   }
			    product.setQuantity(rs.getInt(10));
			    product.setRatings(rs.getFloat(11));
			
				products.add(product);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally{
			
			try{
				
				pst1.close();
				pst2.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		
			return products;
	}
	
	
	
	
	public Connection getMySqlConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms1","root", "root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}



	@Override
	public void updateProductName(Product product,String productName) {
	
		Connection conn=null;
		PreparedStatement pst=null;
		String sql="update product set productName=? where productId=?";
		conn=getMySqlConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, productName);
			pst.setInt(2, product.getProductId());
			int count=pst.executeUpdate();
			if(count<=0)
				System.out.println("product name is not updated");
			else
				System.out.println("product name updated sucessfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}



	@Override
	public void updateProductMaxRetailPrice(Product product, double max_price) {
		
		Connection conn=null;
		PreparedStatement pst=null;
		String sql="update product set max_retail_price=? where productId=?";
		conn=getMySqlConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setDouble(1, max_price);
			pst.setInt(2, product.getProductId());
			int count=pst.executeUpdate();
			if(count<=0)
				System.out.println("product maximum reati price is not updated");
			else
				System.out.println("product max retail price updated sucessfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}



	@Override
	public void updateProductRating(Product product, float rating) {
		Connection conn=null;
		PreparedStatement pst=null;
		String sql="update product set ratings=? where productId=?";
		conn=getMySqlConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setFloat(1, rating);
			pst.setInt(2, product.getProductId());
			int count=pst.executeUpdate();
			if(count<=0)
				System.out.println("product rating is not updated");
			else
				System.out.println("product rating updated sucessfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}


	@Override
	public void updateProductCategory(Product product, Category category) {
		Connection conn=null;
		PreparedStatement pst=null;
		String sql="update product set category_Id=? where productId=?";
		conn=getMySqlConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, category.getCategory_Id());
			pst.setInt(2, product.getProductId());
			int count=pst.executeUpdate();
			if(count<=0)
				System.out.println("product category is not updated");
			else
				System.out.println("product category updated sucessfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}

   @Override
	public void updateProductExpiryDate(Product product, Date expiryDate) {
	   Connection conn=null;
		PreparedStatement pst=null;
		String sql="update product set expiry_date=? where productId=?";
		conn=getMySqlConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setDate(1, new java.sql.Date(expiryDate.getTime()));
			pst.setInt(2, product.getProductId());
			int count=pst.executeUpdate();
			if(count<=0)
				System.out.println("product expiry date is not updated");
			else
				System.out.println("product expiry date updated sucessfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}



@Override
public void deleteProduct(int productId) {
	Connection conn=null;
	PreparedStatement pst=null;
	PreparedStatement pst1=null;
	String sql="delete from product where productId=?";
	String sql1="delete from productdiscount where productId=?";
	conn=getMySqlConnection();
	try {
		pst=conn.prepareStatement(sql);
		pst.setInt(1, productId);
		int count=pst.executeUpdate();
		pst1=conn.prepareStatement(sql1);
		pst1.setInt(1, productId);
		int count1=pst1.executeUpdate();
		if(count<=0)
		
			System.out.println("produc not found");
		
		else
			System.out.println("product removed sucessfully");
	
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
}
	
	
	
	
	
	
	
	
}
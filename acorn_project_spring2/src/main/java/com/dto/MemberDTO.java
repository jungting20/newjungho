package com.dto;

public class MemberDTO {
	
	
	private String id;
    private String name;
    private String birthdate;
    private String password;
    private String gender;
    private String phone_num;
    private String email;
    private int confirmation;
    private String classification;
    private String articlecategory;
    
    
    
    
    
    public MemberDTO(String id, String name, String birthdate, String password, String gender, String phone_num,
			String email, int confirmation, String classification, String articlecategory) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.password = password;
		this.gender = gender;
		this.phone_num = phone_num;
		this.email = email;
		this.confirmation = confirmation;
		this.classification = classification;
		this.articlecategory = articlecategory;
	}


	public String getArticlecategory() {
		return articlecategory;
	}


	public void setArticlecategory(String articlecategory) {
		this.articlecategory = articlecategory;
	}


	public String getPhone_num() {
		return phone_num;
	}


	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}


    
    
    public MemberDTO(String id, String name, String birthdate, String password, String gender, String phonenum,
          String email) {
       super();
       this.id = id;
       this.name = name;
       this.birthdate = birthdate;
       this.password = password;
       this.gender = gender;
       this.phone_num = phonenum;
       this.email = email;
    }
    
    
    public MemberDTO(String id, String name, String birthdate, String password, String gender, String phone_num,
          String email, int confirmation) {
       super();
       this.id = id;
       this.name = name;
       this.birthdate = birthdate;
       this.password = password;
       this.gender = gender;
       this.phone_num = phone_num;
       this.email = email;
       this.confirmation = confirmation;
    }


    public MemberDTO(String id, String name, String birthdate, String password, String gender, String phone_num,
          String email, int confirmation, String classification) {
       super();
       this.id = id;
       this.name = name;
       this.birthdate = birthdate;
       this.password = password;
       this.gender = gender;
       this.phone_num = phone_num;
       this.email = email;
       this.confirmation = confirmation;
       this.classification = classification;
    }


    public MemberDTO() {
       super();
       // TODO Auto-generated constructor stub
    }
    public String getId() {
       return id;
    }
    public void setId(String id) {
       this.id = id;
    }
    public String getName() {
       return name;
    }
    public void setName(String name) {
       this.name = name;
    }
    public String getBirthdate() {
       return birthdate;
    }
    public void setBirthdate(String birthdate) {
       this.birthdate = birthdate;
    }
    public String getPassword() {
       return password;
    }
    public void setPassword(String password) {
       this.password = password;
    }
    public String getGender() {
       return gender;
    }
    public void setGender(String gender) {
       this.gender = gender;
    }
    public String getPhonenum() {
       return phone_num;
    }
    public void setPhonenum(String phonenum) {
       this.phone_num = phonenum;
    }
    public String getEmail() {
       return email;
    }
    public void setEmail(String email) {
       this.email = email;
    }

    public int getConfirmation() {
       return confirmation;
    }


    public void setConfirmation(int confirmation) {
       this.confirmation = confirmation;
    }


    public String getClassification() {
       return classification;
    }


    public void setClassification(String classification) {
       this.classification = classification;
    }


    @Override
    public String toString() {
       return "StudentDTO [id=" + id + ", name=" + name + ", birthdate=" + birthdate + ", password=" + password
             + ", gender=" + gender + ", phonenum=" + phone_num + ", email=" + email + "]";
    }
    
	
	
	
}

package com.May2026.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.May2026.demo.entity.Department;
import com.May2026.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository repo;
	public Department saveDepartment(Department dept)
	{
		return repo.save(dept);
	}
	public List<Department> getAllDepartment()
	{
		return repo.findAll();
	}
	public Department getDepartmentById(Integer Id)
	{
		return repo.findById(Id).orElse(null);
	}
	public Department updateDepartment(Integer id,Department dept)
	{
		Department existing = repo.findById(id).orElse(null);
		if(existing!=null)
		{
			existing.setDept_id(dept.getDept_id());
			existing.setDept_name(dept.getDept_name());
			return repo.save(existing);
		}
		return null;
	}
	
	public String deleteDepartment(Integer id)
	{
		repo.deleteById(id);
		return "Department deleted successfully";
	}
}

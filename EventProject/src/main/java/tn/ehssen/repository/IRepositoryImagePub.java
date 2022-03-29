package tn.ehssen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.ehssen.entity.UploadImagePublication;



@Repository
public interface IRepositoryImagePub extends CrudRepository<UploadImagePublication,Long> {
}

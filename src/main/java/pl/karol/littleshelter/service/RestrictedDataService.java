package pl.karol.littleshelter.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import pl.karol.littleshelter.entity.RestrictedData;
import pl.karol.littleshelter.entity.User;

@Service
public interface RestrictedDataService {
	
	Set<RestrictedData> findRestrictedData(User user);
	
	Set<RestrictedData> addRestrictedData(User user);
	
	Set<RestrictedData> updateRestrictedData(User user);
	
	Set<RestrictedData> removeRestrictedData(User user);

}

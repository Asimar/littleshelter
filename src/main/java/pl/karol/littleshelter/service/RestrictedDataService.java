package pl.karol.littleshelter.service;

import java.util.Set;

import pl.karol.littleshelter.entity.RestrictedData;
import pl.karol.littleshelter.entity.User;

public interface RestrictedDataService {
	
	Set<RestrictedData> addRestrictedData(User user, RestrictedData data);
	
	Set<RestrictedData> updateRestrictedData(User user, RestrictedData data);
	
	Set<RestrictedData> removeRestrictedData(User user, RestrictedData data);

}

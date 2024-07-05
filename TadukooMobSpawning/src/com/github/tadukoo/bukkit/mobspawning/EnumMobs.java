package com.github.tadukoo.bukkit.mobspawning;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;

public enum EnumMobs{
	SKELETON("Skeleton", 51, EntityType.SKELETON, Skeleton.class, Skeleton.class);
	 
    private String name;
    private int id;
    private EntityType entityType;
    private Class<? extends LivingEntity> nmsClass;
    private Class<? extends LivingEntity> customClass;
 
    private EnumMobs(String name, int id, EntityType entityType, Class<? extends LivingEntity> nmsClass,
    		Class<? extends LivingEntity> customClass){
        this.name = name;
        this.id = id;
        this.entityType = entityType;
        this.nmsClass = nmsClass;
        this.customClass = customClass;
    }
 
    public String getName(){
        return this.name;
    }
 
    public int getID(){
        return this.id;
    }
 
    public EntityType getEntityType(){
        return this.entityType;
    }
 
    public Class<? extends LivingEntity> getNMSClass(){
        return this.nmsClass;
    }
 
    public Class<? extends LivingEntity> getCustomClass(){
        return this.customClass;
    }
}

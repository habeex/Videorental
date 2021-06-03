package com.example.videorental.utilities;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class SearchSpecification<T> {
    public Specification<T> query(String text) {
        if (!text.contains("%")) {
            text = "%" + text + "%";
        }
        final String finalText = text;
        return  (Specification<T>) (root, query, builder) ->
                builder.or(root.getModel().getDeclaredSingularAttributes().stream().filter(a -> {
                    if (a.getJavaType().getSimpleName().equalsIgnoreCase("string")) {
                        return true;
                    } else {
                        return false;
                    }
                }).map(a -> builder.like(root.get(a.getName()), finalText)).toArray(Predicate[]::new));
    }

    public Specification<T> equal(String key, Object value) {
        return  (Specification<T>) (root, query, builder) ->
                builder.and(root.getModel().getDeclaredSingularAttributes().stream().filter(a -> {
                    if (a.getJavaType().getSimpleName().equalsIgnoreCase("string")) {
                        return true;
                    } else {
                        return false;
                    }
                }).map(a -> builder.equal(root.get(key), value)).toArray(Predicate[]::new));
    }

    public Specification<T> notEqual(String key, Object value) {
        return  (Specification<T>) (root, query, builder) ->
                builder.and(root.getModel().getDeclaredSingularAttributes().stream().filter(a -> {
                    if (a.getJavaType().getSimpleName().equalsIgnoreCase("string")) {
                        return true;
                    } else {
                        return false;
                    }
                }).map(a -> builder.notEqual(root.get(key), value)).toArray(Predicate[]::new));
    }

    public Specification<T> like(String key, String value) {
        return  (Specification<T>) (root, query, builder) ->
                builder.or(root.getModel().getDeclaredSingularAttributes().stream().filter(a -> {
                    if (a.getJavaType().getSimpleName().equalsIgnoreCase("string")) {
                        return true;
                    } else {
                        return false;
                    }
                }).map(a -> builder.like(root.get(key), value)).toArray(Predicate[]::new));
    }

}

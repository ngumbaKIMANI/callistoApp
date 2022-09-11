package com.callisto.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    @Id
    @SequenceGenerator(name = "brand_id_sequence", sequenceName = "brand_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_id_generator")
    private Long id;
    private String title;
    private String summary;
    private Date createdAt;
    private Date updatedAt;
    private String content;
}

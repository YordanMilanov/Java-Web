package com.softuni.pathfinder.domain.entities;

import com.softuni.pathfinder.domain.enums.Level;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{

    @Column(columnDefinition = "LONGTEXT", length = 3000)
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private Level level;

    @Column
    private String name;

    @ManyToOne
    private User author;

    @Column(name = "video_url")
    private String video;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @OneToMany(targetEntity = Comment.class,
            mappedBy ="route",
            cascade = {CascadeType.MERGE,CascadeType.DETACH})
    private Set<Comment> comments;

    @OneToMany(targetEntity = Picture.class,
            mappedBy = "route",
            cascade = {CascadeType.MERGE,CascadeType.DETACH})
    private Set<Picture> pictures;

    @ManyToMany
    private Set<Category> categories;

    public Route() {
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public Route setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public Route setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public Route setName(String name) {
        this.name = name;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Route setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getVideo() {
        return video;
    }

    public Route setVideo(String video) {
        this.video = video;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Route setDescription(String description) {
        this.description = description;
        return this;
    }
}

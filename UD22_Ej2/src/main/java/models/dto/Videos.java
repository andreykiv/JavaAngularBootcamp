package models.dto;

public class Videos {
	//atributos
	private Integer idVideo;
	private String titleVideo;
	private String directorVideo;
	private Integer	cli_idVideo;
	
	
	//GETTERS Y SETTERS
	public Integer getIdVideo() {
		return idVideo;
	}
	public void setIdVideo(Integer idVideo) {
		this.idVideo = idVideo;
	}
	public String getTitleVideo() {
		return titleVideo;
	}
	public void setTitleVideo(String titleVideo) {
		this.titleVideo = titleVideo;
	}
	public String getDirectorVideo() {
		return directorVideo;
	}
	public void setDirectorVideo(String directorVideo) {
		this.directorVideo = directorVideo;
	}
	public Integer getCli_idVideo() {
		return cli_idVideo;
	}
	public void setCli_idVideo(Integer cli_idVideo) {
		this.cli_idVideo = cli_idVideo;
	}
	
}

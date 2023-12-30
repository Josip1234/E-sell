package sell.files;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="storage_system")
public class Storage {
	@Null
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@NonNull
	@NotNull
	@Column(name="nickname")
	private String nickname;
	@NonNull
	@NotNull
	@Column(name="article_number")
	private String article_number;
	@NonNull
	@NotNull
	@Column(name="user_folder")
	private String user_folder;
	@NonNull
	@NotNull
	@Column(name="article_folder")
	private String article_folder;
	@NonNull
	@NotNull
	@Column(name="file_name")
	private String file_name;
	@NonNull
	@NotNull
	@Column(name="file_extension")
	private String file_extension;
	@NonNull
	@NotNull
	@Column(name="local_path")
	private String local_path;
	@NonNull
	@NotNull
	@Column(name="url")
	private String url;
	@NonNull
	@NotNull
	@Column(name="type")
	private String type;
	@NonNull
	@NotNull
	@Column(name="relative_link")
	private String relative_link;
	
}

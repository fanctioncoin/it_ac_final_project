package by.staravoyt.app.models.auth;

import java.util.Collection;
import java.util.LinkedHashSet;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import by.staravoyt.app.models.EntityModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@ToString(callSuper = true, exclude = {"roles","authorities"})
@EqualsAndHashCode(callSuper = true, exclude = {"roles","authorities"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity( name = "usr")
@Builder
public class CredUser extends EntityModel
{

    private String username;

    private String password;

    private boolean enabled;


    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(name = "usr_role",
            joinColumns = @JoinColumn(name = "usr_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles = new LinkedHashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(name = "usr_authority",
            joinColumns = @JoinColumn(name = "usr_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Collection<Authority> authorities= new LinkedHashSet<>();


    @Override
    public CredUser withId(Integer id) {
        setId(id);
        return this;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(final boolean enabled)
    {
        this.enabled = enabled;
    }

    public Collection<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(final Collection<Role> roles)
    {
        this.roles = roles;
    }
}


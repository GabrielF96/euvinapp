package com.euvin.euvin.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Usuario", uniqueConstraints = @UniqueConstraint(columnNames = "email_usuario"))
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="email_usuario", nullable = false, unique = true)
    private String email;

    @Column(name="senha_usuario", nullable = false)
    private String password;

    @Column(name="nome_usuario")
    private String nome;
    
    @Column(name="cpf_usuario")
    private String cpf;
    
    @Column(name="cargo_usuario")
    private String cargo;
    
    @Column(name="turno_usuario")
    private String turno;
    
    @Column(name="saldo_de_horas_usuario")
    private Double saldoDeHoras;
    
    @Column(name="primeiro_acesso")
    private boolean primeiroAcesso;
    
    @Column(name="roles")
    private String roles = "";
    
    @Column(name="permissions")
    private String permissions = "";
    
    @Transient
    private String passwordAnterior;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public List<String> getRolesList(){
        if(this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
    
    public List<String> getPermissionList(){
        if(this.permissions.length()>0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Double getSaldoDeHoras() {
		return saldoDeHoras;
	}

	public void setSaldoDeHoras(Double saldoDeHoras) {
		this.saldoDeHoras = saldoDeHoras;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isPrimeiroAcesso() {
		return primeiroAcesso;
	}

	public void setPrimeiroAcesso(boolean primeiroAcesso) {
		this.primeiroAcesso = primeiroAcesso;
	}

	public String getPasswordAnterior() {
		return passwordAnterior;
	}

	public void setPasswordAnterior(String passwordAnterior) {
		this.passwordAnterior = passwordAnterior;
	}
}
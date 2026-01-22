package com.example.testapp.model.userlogin

import com.google.gson.annotations.SerializedName


data class UserDTO(

    @field:SerializedName("status_login")
    val statusLogin: String? = null,

    @field:SerializedName("last_login_at")
    val lastLoginAt: String? = null,

    @field:SerializedName("role")
    val role: String? = null,

    @field:SerializedName("is_active")
    val isActive: String? = null,

    @field:SerializedName("jabatan")
    val jabatan: String? = null,

    @field:SerializedName("kode_provider")
    val kodeProvider: String? = null,

    @field:SerializedName("kode_kanca")
    val kodeKanca: Any? = null,

    @field:SerializedName("menu")
    val menu: List<MenuItemDTO?>? = null,

    @field:SerializedName("kode_kanwil")
    val kodeKanwil: Any? = null,

    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("is_change_password")
    val isChangePassword: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("nomor_hp")
    val nomorHp: String? = null,

    @field:SerializedName("username")
    val username: String? = null
)
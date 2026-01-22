package com.example.testapp.model.userlogin

import com.google.gson.annotations.SerializedName

data class MenuItemDTO(

    @field:SerializedName("parent_slug")
    val parentSlug: Any? = null,

    @field:SerializedName("menu_slug")
    val menuSlug: String? = null,

    @field:SerializedName("role_id")
    val roleId: String? = null,

    @field:SerializedName("menu")
    val menu: String? = null
)
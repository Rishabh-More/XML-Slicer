package com.qwerty.soapapitest.codebase.dependencies

import com.qwerty.soapapitest.codebase.models.middleware.Login
import org.koin.dsl.module

val restClassModule = module {
    factory { Login() }
}
package com.example.bishkekrielt.data.repository


import com.example.bishkekrielt.data.model.Data
import com.example.bishkekrielt.data.remote.SharesService
import retrofit2.Response

interface Repository {
    suspend fun loadDescription(): Response <Data>

}

class RepositoryImp(private val service: SharesService) : Repository {
    override suspend fun loadDescription(): Response<Data> {
        return service.getShares()
    }




}
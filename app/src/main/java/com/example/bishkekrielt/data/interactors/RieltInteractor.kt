package com.example.bishkekrielt.data.interactors


import com.example.bishkekrielt.data.model.Data
import com.example.bishkekrielt.data.remote.SharesService
import retrofit2.Response

interface RieltInteractor {
    suspend fun loadDescription(): Response <Data>
    suspend fun loadDescription2(): Response <Data>

}

class RieltInteractorImp(private val service: SharesService) : RieltInteractor {
    override suspend fun loadDescription(): Response<Data> {
        return service.getShares2()
    }

    override suspend fun loadDescription2(): Response<Data> {
        return service.getShares()
    }


}
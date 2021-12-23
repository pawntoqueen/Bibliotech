package com.pawntoqueen.android.bibliotech.utils

import android.content.Context
import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


abstract class FragmentUtil<VM : ViewModel?, VB : ViewBinding> : Fragment() {

    abstract var viewModel: VM?
    private var _binding: VB? = null

     val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /////////////////////////////VB sınıfının ne olduğunu anlaması için bir metod/////////////////////////////////////////
        val superclass: Type = javaClass.genericSuperclass!!
        val aClass = (superclass as ParameterizedType).actualTypeArguments[1] as Class<*>
        val method: Method = aClass.getDeclaredMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.javaPrimitiveType
        )
        ////////////////////////////////Metod bitti ///////////////////////////////////////////////////////////////////////

        _binding = method.invoke(null, layoutInflater, container, false) as VB
        prepareView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        prepareViewModel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    abstract fun prepareView()
    abstract fun prepareViewModel()


}
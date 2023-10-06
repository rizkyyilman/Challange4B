import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.catnip.challange3.databinding.ActivityDetailBinding
import com.catnip.challange3.model.DetailMenu

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan objek DetailMenu yang dikirimkan melalui argumen
        val detailMenu = intent.getParcelableExtra<DetailMenu>("detailmenu")

        // Tampilkan data DetailMenu di layout DetailActivity,
        if (detailMenu != null) {
            binding.tvHeadlineMenu.text = detailMenu.name
            binding.tvPriceDetail.text = detailMenu.price
            binding.tvDescriptionMenu.text = detailMenu.desc

        } else {

            binding.tvHeadlineMenu.text = "Detail Menu Tidak Tersedia"
            binding.tvPriceDetail.text = ""
            binding.tvDescriptionMenu.text = ""
        }

        binding.ivBackIcon.setOnClickListener {
            onBackPressed()
        }
    }
}
